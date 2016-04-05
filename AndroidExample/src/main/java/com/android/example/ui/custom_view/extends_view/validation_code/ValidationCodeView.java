package com.android.example.ui.custom_view.extends_view.validation_code;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.android.example.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 描述：绚丽的验证码
 * Created by Administrator on 2016/3/8 0008.
 */
public class ValidationCodeView extends View {
    /**
     * 验证码
     */
    private String mCodeString;
    /**
     * 文字画笔
     */
    private Paint mTextPaint;

    /**
     * 干扰点画笔
     */
    private Paint mPointPaint;

    /**
     * 干扰线画笔
     */
    private Paint mPathPaint;
    /**
     * 获取验证码字符串显示的宽度
     */
    private float mTextWidth;
    /**
     * 验证码字符大小
     */
    private float mTextSize;

    /**
     * 验证码控件的宽
     */
    private int mWidth;
    /**
     * 验证码控件的高
     */
    private int mHeight;

    /**
     * 装载干扰点list
     */
    private List<PointF> mPoints = new ArrayList<>();
    /**
     * 装载干扰线list
     */
    private List<Path> mPaths = new ArrayList<>();

    /**
     * 验证码个数
     */
    private int mCodeCount;

    /**
     * 在java代码创建View时调用，即new
     */
    public ValidationCodeView(Context context) {
        this(context, null);
    }

    /**
     * 在xml布局文件中使用View，并且没有指明style时调用
     */
    public ValidationCodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 在xml布局文件中使用View并且指定style时调用
     */
    public ValidationCodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrValues(context, attrs);
        init();
    }

    /**
     * 重写onMeasure,完成View大小的测量
     * 要想layout_width和layout_height支持wrap_content,必须重写该方法
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //分别测量控件的高度和宽度，基本为模版方法
        int measureWidth = measureWidth(widthMeasureSpec);
        int measureHeight = measureHeight(heightMeasureSpec);

        //将测量出来的宽高设置进去完成测量
        setMeasuredDimension(measureWidth, measureHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initData();

        int length = mCodeString.length();
        float charLength = mTextWidth / length;
        for (int i = 1; i <= length; i++) {
            int offsetDegree = mRandom.nextInt(15);
            //这里只会产生0或1，如果是1则旋转正角度，否则旋转负角度
            offsetDegree = mRandom.nextInt(2) == 1 ? offsetDegree : -offsetDegree;
            canvas.save();
            canvas.rotate(offsetDegree, mWidth / 2, mHeight / 2);
            //给画笔设置随机颜色
            mTextPaint.setARGB(255, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20);
            canvas.drawText(String.valueOf(mCodeString.charAt(i - 1)), (i - 1) * charLength * 1.6f + 30, mHeight * 2 / 3f, mTextPaint);
            canvas.restore();
        }

        //产生干扰点
        for (PointF pointF : mPoints) {
            mPointPaint.setARGB(255, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20);
            canvas.drawPoint(pointF.x, pointF.y, mPointPaint);
        }

        //产生干扰线
        for (Path path : mPaths) {
            mPathPaint.setARGB(255, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20);
            canvas.drawPath(path, mPathPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //重新生成验证码
                mCodeString = getCharAndNum(mCodeCount);
                invalidate();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 初始化一些数据
     */
    public void init() {
        //生成随机数字和字母组合
        mCodeString = getCharAndNum(mCodeCount);
        //初始化文字画笔
        mTextPaint = new Paint();
        mTextPaint.setStrokeWidth(3);//设置画笔宽度为3
        mTextPaint.setTextSize(mTextSize);//设置文字大小
        //初始化干扰点画笔
        mPointPaint = new Paint();
        mPointPaint.setStrokeWidth(6);
        mPointPaint.setStrokeCap(Paint.Cap.ROUND);//设置断点处为圆形
        //初始化干扰线画笔
        mPathPaint = new Paint();
        mPathPaint.setStrokeWidth(5);
        mPathPaint.setColor(Color.GRAY);
        mPathPaint.setStyle(Paint.Style.STROKE);//设置画笔为空心
        mPathPaint.setStrokeCap(Paint.Cap.ROUND);//设置断电处为圆形

        //取得验证码字符串显示的宽度值
        mTextWidth = mTextPaint.measureText(mCodeString);
    }

    private Random mRandom = new Random();

    /**
     * 初始化数据
     */
    private void initData() {
        //获取控件的宽和高，此时已经测量wancheng
        mWidth = getWidth();
        mHeight = getHeight();

        mPoints.clear();
        //生成干扰点坐标
        for (int i = 0; i < 150; i++) {
            //随机坐标
            PointF pointF = new PointF(mRandom.nextInt(mWidth) + 10, mRandom.nextInt(mHeight) + 10);
            mPoints.add(pointF);
        }

        mPaths.clear();
        //生成干扰线坐标
        for (int i = 0; i < 2; i++) {
            Path path = new Path();
            int startX = mRandom.nextInt(mWidth / 3) + 10;
            int startY = mRandom.nextInt(mHeight / 3) + 10;
            int endX = mRandom.nextInt(mWidth / 2) + mWidth / 2 - 10;
            int endY = mRandom.nextInt(mHeight / 2) + mHeight / 2 - 10;
            path.moveTo(startX, startY);
            path.quadTo(Math.abs(endX - startX) / 2, Math.abs(endY - startY) / 2, endX, endY);
            mPaths.add(path);
        }

    }

    /**
     * 获取布局文件中的值
     */
    private void getAttrValues(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.IndentifyingCode);
        //获取布局文件中验证码位数属性值，默认为5个
        mCodeCount = typedArray.getInteger(R.styleable.IndentifyingCode_codeCount, 5);
        //默认字体大小的值
//        int defValue = typedArray.getDimensionPixelSize(
//                R.styleable.IndentifyingCode_textSize,
//                (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics())
//                );
        //获取布局文件中验证码文字大小的值，默认为20
        mTextSize = typedArray.getDimension(R.styleable.IndentifyingCode_textSize, 20);
        typedArray.recycle();
    }

    /**
     * java生成的随机数组和字母组合
     *
     * @param length:生成随机数的长度
     */
    private String getCharAndNum(int length) {
        String var = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            //输出字母还是数字
            String charOrNum = random.nextInt() % 2 == 0 ? "char" : "num";
            //字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                //取得大写字母还是小写字母
                int choice = random.nextInt() % 2 == 0 ? 65 : 97;
                var += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                var += String.valueOf(random.nextInt(10));
            }
        }
        return var;
    }

    /**
     * 测量宽度
     */
    private int measureWidth(int widthMeasureSpec) {
        int result = (int) (mTextWidth * 1.8f);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            //精确测量模式，即布局文件中layout_width或layout_height一般为精确的值或者为match_parent
            result = widthSize;//既然为精确模式，直接返回测量的宽度即可
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //最大值模式，即布局文件中layout_width或layout_height一般为wrap_content
            result = Math.min(result, widthSize);
        }
        return result;
    }

    /**
     * 测量高度
     */
    private int measureHeight(int heightMeasureSpec) {
        int result = (int) (mTextWidth / 1.6f);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.EXACTLY) {
            //精确测量模式，即布局文件中layout_width或layout_height一般为精确的值或者为match_parent
            result = heightSize;//既然为精确模式，直接返回测量的高度即可
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //最大值模式，即布局文件中layout_width或layout_height一般为wrap_content
            result = Math.min(result, heightSize);
        }
        return result;
    }

    /**
     * 获取验证码
     */
    public String getCodeString() {
        return mCodeString;
    }

    /**
     * 刷新
     */
    public void refresh() {
        mCodeString = getCharAndNum(mCodeCount);
        invalidate();
    }
}
