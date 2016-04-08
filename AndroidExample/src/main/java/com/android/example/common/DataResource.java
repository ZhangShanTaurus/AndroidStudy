package com.android.example.common;

import com.android.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：数据源
 * Created by Administrator on 2016/1/14 0014.
 */
public class DataResource {

    /**
     * 存放展示的数据
     **/
    private List<Integer> list;

    public DataResource(int type) {
        initData(type);
    }

    /**
     * 根据类型初始化数据源
     */
    private void initData(int type) {
        switch (type) {
            case Constance.BASE_KNOWLEDGE:
                list = new ArrayList<Integer>();
                list.add(R.string.JavaBase);
                list.add(R.string.data_structure);
                list.add(R.string.object_oriented_ideas);
                list.add(R.string.design_mode);
                list.add(R.string.android_sdk);
                list.add(R.string.activity);
                list.add(R.string.service);
                list.add(R.string.broadcast_receiver);
                list.add(R.string.content_provider);
                list.add(R.string.action_bar);
                list.add(R.string.fragment);
                list.add(R.string.handler_looper_message);
                break;
            case Constance.HANDLER_LOOPER_MESSAGE:
                list = new ArrayList<Integer>();
                list.add(R.string.looper_base_info);
                list.add(R.string.handler_base_info);
                list.add(R.string.message_base_info);
                list.add(R.string.message_queue_info);
                list.add(R.string.handler_summary);
                break;
            case Constance.SERVICE:
                list = new ArrayList<Integer>();
                list.add(R.string.simpleService);
                list.add(R.string.serviceCommunicationToActivity);
                list.add(R.string.serviceDestroyWay);
                list.add(R.string.serviceAndThread);
                list.add(R.string.foregroundService);
                list.add(R.string.remoteService);
                list.add(R.string.intentService);
                break;
            case Constance.ACTIVITY:
                list = new ArrayList<Integer>();
                list.add(R.string.activity_lifecycle);
                list.add(R.string.activity_data_transmit);
                list.add(R.string.activity_launchMode);
                break;
            case Constance.ACTIVITY_LUNCHMODE:
                list = new ArrayList<Integer>();
                list.add(R.string.activity_lunchMode_standard);
                list.add(R.string.activity_lunchMode_singleTop);
                list.add(R.string.activity_lunchMode_singleTask);
                list.add(R.string.activity_lunchMode_singleInstance);
                break;
            case Constance.JAVA_BASE:
                list = new ArrayList<Integer>();
                break;
            case Constance.DATA_STRUCTURE:
                list = new ArrayList<Integer>();
                break;
            case Constance.OBJECT_IDEAS:
                list = new ArrayList<Integer>();
                break;
            case Constance.ANDROID_SDK:
                list = new ArrayList<Integer>();
                break;
            case Constance.DATA_PARSER:
                list = new ArrayList<Integer>();
                list.add(R.string.json_parser);
                list.add(R.string.xml_parser);
                break;
            case Constance.DATA_XML_PARSER:
                list = new ArrayList<Integer>();
                list.add(R.string.xml_base_info);
                list.add(R.string.pull_parser);
                list.add(R.string.sax_parser);
                list.add(R.string.dom_parser);
                break;
            case Constance.MULTI_THREAD:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_concept);
                list.add(R.string.thread_create_run);
                list.add(R.string.thread_stack_model);
                list.add(R.string.thread_state_convert);
                list.add(R.string.thread_sync_lock);
                list.add(R.string.thread_interaction);
                list.add(R.string.thread_dispatch);
                list.add(R.string.thread_concurrent);
                list.add(R.string.thread_new_character);
                break;
            case Constance.MULTI_THREAD_CONCEPT:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_process);
                list.add(R.string.thread_in_java);
                break;
            case Constance.MULTI_THREAD_CREATE_RUN:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_define);
                list.add(R.string.thread_instantiation);
                list.add(R.string.thread_start);
                list.add(R.string.thread_problem);
                list.add(R.string.thread_sample);
                break;
            case Constance.MULTI_THREAD_STACK_MODEL:
                list = new ArrayList<Integer>();
                break;
            case Constance.MULTI_THREAD_CONVERT:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_state);
                list.add(R.string.thread_priority);
                list.add(R.string.thread_sleep1);
                list.add(R.string.thread_yield);
                list.add(R.string.thread_join);
                list.add(R.string.thread_state_convert_summary);
                break;
            case Constance.MULTI_THREAD_SYNC_LOCK:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_sync_problem);
                list.add(R.string.thread_sync_lock1);
                list.add(R.string.thread_static_method_sync);
                list.add(R.string.thread_not_get_lock);
                list.add(R.string.thread_when_sync);
                list.add(R.string.thread_safe_class);
                list.add(R.string.thread_dead_lock);
                list.add(R.string.thread_sync_lock_summary);
                break;
            case Constance.MULTI_THREAD_INTERACTION:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_base_knowledge);
                list.add(R.string.thread_more_wait_lock);
                break;
            case Constance.MULTI_THREAD_DISPATCH:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_sleep);
                list.add(R.string.thread_priority1);
                list.add(R.string.thread_concession);
                list.add(R.string.thread_merge);
                list.add(R.string.thread_guard);
                list.add(R.string.thread_sync_method);
                list.add(R.string.thread_sync_block);
                break;
            case Constance.MULTI_THREAD_CONCURRENT:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_producer_consumer);
                list.add(R.string.thread_dead_lock1);
                list.add(R.string.thread_volatile);
                break;
            case Constance.MULTI_THREAD_NEW_CHARACTER:
                list = new ArrayList<Integer>();
                list.add(R.string.thread_pool);
                list.add(R.string.thread_return_value);
                list.add(R.string.thread_lock_one);
                list.add(R.string.thread_lock_two);
                list.add(R.string.thread_semaphore);
                list.add(R.string.thread_blocking_queue);
                list.add(R.string.thread_blocking_stack);
                list.add(R.string.thread_condition_variable);
                list.add(R.string.thread_atomic_mass);
                list.add(R.string.thread_obstruction_marker);
                break;
            case Constance.BROADCAST_RECEIVER:
                list = new ArrayList<Integer>();
                list.add(R.string.static_register);
                list.add(R.string.dynamic_register);
                list.add(R.string.normal_broadcast);
                list.add(R.string.order_broadcast);
                break;
            case Constance.CONTENT_PROVIDER:
                list = new ArrayList<Integer>();
                list.add(R.string.contentProviderBaseInfo);
                list.add(R.string.getSystemContact);
                list.add(R.string.customContentProvider);
                break;
            case Constance.ACTION_BAR:
                list = new ArrayList<Integer>();
                break;
            case Constance.FRAGMENT:
                list = new ArrayList<Integer>();
                list.add(R.string.fragment_introduce);
                list.add(R.string.fragment_lifecycle);
                list.add(R.string.fragment_data_transmit);
                list.add(R.string.fragment_static_add);
                list.add(R.string.fragment_dynamic_add);
                list.add(R.string.manage_fragment_stack);
                list.add(R.string.fragment_communication_activity);
                list.add(R.string.fragment_change);
                list.add(R.string.fragment_with_actionBar_menuItem);
                list.add(R.string.fragment_null);
                list.add(R.string.dialog_fragment);
                break;
            case Constance.UI:
                list = new ArrayList<Integer>();
                list.add(R.string.Layout);
                list.add(R.string.View);
                list.add(R.string.CustomView);
                list.add(R.string.anim);
                list.add(R.string.Resource);
                list.add(R.string.OpenGL);
                list.add(R.string.event_dispatch);
                break;
            case Constance.COMMUNICATION:
                list = new ArrayList<Integer>();
                list.add(R.string.tcp_udp);
                list.add(R.string.http);
                list.add(R.string.socket);
                list.add(R.string.bluetooth);
                list.add(R.string.nfc);
                list.add(R.string.headset);
                list.add(R.string.usb);
                break;
            case Constance.PERSISTENCE:
                list = new ArrayList<Integer>();
                list.add(R.string.SQLite);
                list.add(R.string.file);
                list.add(R.string.sharedPreferences);
                break;
            case Constance.PERFORMANCE:
                list = new ArrayList<Integer>();
                list.add(R.string.ui_optimize);
                list.add(R.string.memory_optimize);
                list.add(R.string.electric_optimize);
                list.add(R.string.flow_optimize);
                break;
            case Constance.PERFORMANCE_UI_OPTIMIZE:
                list = new ArrayList<Integer>();
                list.add(R.string.layoutHierarchy);
                list.add(R.string.useAbstractLayout);
                list.add(R.string.hierarchyViewer);
                list.add(R.string.lintTool);
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE:
                list = new ArrayList<Integer>();
                list.add(R.string.oom);
                list.add(R.string.image_handle);
                list.add(R.string.cache_machining);
                list.add(R.string.anr);
                list.add(R.string.analyze);
                break;
            case Constance.DEBUG:
                list = new ArrayList<Integer>();
                list.add(R.string.logcat);
                list.add(R.string.adb);
                list.add(R.string.hierarchy_viewer);
                list.add(R.string.traceview);
                list.add(R.string.heap);
                list.add(R.string.lint);
                break;
            case Constance.ADAPTIVE:
                list = new ArrayList<Integer>();
                list.add(R.string.os_version);
                list.add(R.string.screen_size);
                list.add(R.string.screen_px);
                break;
            case Constance.TEST:
                list = new ArrayList<Integer>();
                list.add(R.string.monkey);
                list.add(R.string.monkey_runner);
                list.add(R.string.junit);
                list.add(R.string.robotium);
                list.add(R.string.appium);
                list.add(R.string.athrun);
                list.add(R.string.ui_automator);
                break;
            case Constance.SAFE:
                list = new ArrayList<Integer>();
                list.add(R.string.server_safe);
                list.add(R.string.communication_safe);
                list.add(R.string.data_encryption);
                list.add(R.string.data_attestation);
                list.add(R.string.code_confusion);
                list.add(R.string.call_safe);
                list.add(R.string.other_safe);
                break;
            case Constance.NDK:
                list = new ArrayList<Integer>();
                list.add(R.string.jni);
                list.add(R.string.c);
                list.add(R.string.c1);
                break;
            case Constance.PHONE_FUNCTION:
                list = new ArrayList<Integer>();
                list.add(R.string.phone);
                list.add(R.string.SMS);
                list.add(R.string.sd_card);
                list.add(R.string.camera);
                list.add(R.string.audio);
                list.add(R.string.sensor);
                break;
            case Constance.PHONE_FUNCTION_SENSOR:
                list = new ArrayList<Integer>();
                list.add(R.string.accelerate);
                list.add(R.string.direction);
                list.add(R.string.gravity);
                list.add(R.string.lightRay);
                list.add(R.string.gyroscope);
                list.add(R.string.magneticField);
                list.add(R.string.approach);
                list.add(R.string.temperature);
                list.add(R.string.pressure);
                list.add(R.string.linearAcceleration);
                list.add(R.string.rotation);
                break;
            case Constance.EXTEND:
                list = new ArrayList<Integer>();
                list.add(R.string.map);
                list.add(R.string.speech_recognition);
                list.add(R.string.pay);
                list.add(R.string.statistic_analysis);
                list.add(R.string.advertisement);
                break;
            case Constance.OTHER:
                list = new ArrayList<Integer>();
                list.add(R.string.intent);
                list.add(R.string.android_manifest);
                list.add(R.string.aidl);
                list.add(R.string.wifi);
                list.add(R.string.Internationalization);
                list.add(R.string.popupWindow);
                break;
            case Constance.LAYOUT:
                list = new ArrayList<Integer>();
                list.add(R.string.my_frameLayout);
                list.add(R.string.my_linearLayout);
                list.add(R.string.my_drawerLayout);
                list.add(R.string.my_gridLayout);
                list.add(R.string.my_tableLayout);
                list.add(R.string.my_relativeLayout);
                list.add(R.string.my_sliding_panel_layout);
                break;
            case Constance.VIEW:
                list = new ArrayList<Integer>();
                list.add(R.string.widgets);
                list.add(R.string.containers);
                list.add(R.string.data_time);
                list.add(R.string.expert);
                list.add(R.string.custom);
                break;
            case Constance.CUSTOM_VIEW:
                list = new ArrayList<Integer>();
                list.add(R.string.extends_system_view);
                list.add(R.string.extends_view);
                list.add(R.string.combination_view);
                list.add(R.string.view_coordinate_info);
                break;
            case Constance.EXTENDS_SYSTEM_VIEW:
                list = new ArrayList<Integer>();
                list.add(R.string.extends_linearLayout);
                break;
            case Constance.EXTENDS_VIEW:
                list = new ArrayList<Integer>();
                list.add(R.string.custom_view_setup);
                list.add(R.string.flowery_validation_code);
                list.add(R.string.broken_view);
                list.add(R.string.bezier_view);
                break;
            case Constance.COMBINATION_VIEW:
                list = new ArrayList<Integer>();
                list.add(R.string.combination_view_test);
                break;
            case Constance.RESOURCE:
                list = new ArrayList<Integer>();
                list.add(R.string.assets);
                list.add(R.string.res);
                break;
            case Constance.ANIM:
                list = new ArrayList<Integer>();
                list.add(R.string.view_animation);
                list.add(R.string.property_animation);
                break;
            case Constance.OPEN_GL:
                list = new ArrayList<Integer>();

                break;
            case Constance.WIDGETS:
                list = new ArrayList<Integer>();
                list.add(R.string.textView);
                list.add(R.string.button);
                list.add(R.string.radio_button);
                list.add(R.string.check_box);
                list.add(R.string.switch1);
                list.add(R.string.toggle_button);
                list.add(R.string.image_button);
                list.add(R.string.image_view);
                list.add(R.string.progress_bar);
                list.add(R.string.seek_bar);
                list.add(R.string.rating_bar);
                list.add(R.string.spinner);
                list.add(R.string.webView);
                list.add(R.string.tabLayout);
                break;
            case Constance.CONTAINER:
                list = new ArrayList<Integer>();
                list.add(R.string.radioGroup);
                list.add(R.string.listView);
                list.add(R.string.gridView);
                list.add(R.string.tabHost);
                list.add(R.string.expandableListView);
                list.add(R.string.scrollView);
                list.add(R.string.slidingDrawer);
                list.add(R.string.gallery);
                list.add(R.string.videoView);
                list.add(R.string.dialerFilter);
                list.add(R.string.recyclerView);
                list.add(R.string.cardView);
                break;
            case Constance.DATA_TIME:
                list = new ArrayList<Integer>();
                list.add(R.string.textClock);
                list.add(R.string.analogClock);
                list.add(R.string.chronometer);
                list.add(R.string.datePicker);
                list.add(R.string.timePicker);
                list.add(R.string.calendarView);
                break;
            case Constance.EXPERT:
                list = new ArrayList<Integer>();
                list.add(R.string.space);
                list.add(R.string.checkedTextView);
                list.add(R.string.quickContactBadge);
                list.add(R.string.extractEditText);
                list.add(R.string.autoCompleteTextView);
                list.add(R.string.multiAutoCompleteTextView);
                list.add(R.string.numberPicker);
                list.add(R.string.zoomButton);
                list.add(R.string.chronometer1);
                list.add(R.string.zoomController);
                list.add(R.string.gestureOverlayView);
                list.add(R.string.surfaceView);
                list.add(R.string.textureView);
                list.add(R.string.stackView);
                list.add(R.string.viewStub);
                list.add(R.string.viewAnimator);
                list.add(R.string.viewFlipper);
                list.add(R.string.viewSwitcher);
                list.add(R.string.adapterViewFlipper);
                list.add(R.string.imageViewSwitcher);
                list.add(R.string.textSwitcher);
                list.add(R.string.viewPager);
                break;
            case Constance.CUSTOM:
                list = new ArrayList<Integer>();
                list.add(R.string.include);
                list.add(R.string.fragment1);
                list.add(R.string.requestFocus);
                break;
            case Constance.VIEW_ANIMATION:
                list = new ArrayList<>();
                list.add(R.string.tweenAnimation);
                list.add(R.string.frameAnimation);
                break;
            case Constance.PROPERTY_ANIMATOR:
                list = new ArrayList<>();
                list.add(R.string.property_animation_base_info);
                list.add(R.string.valueAnimator);
                list.add(R.string.objectAnimator);
                list.add(R.string.propertyValuesHolder);
                list.add(R.string.animator_set_code);
                list.add(R.string.animator_set_xml);
                break;
            case Constance.TWEEN_ANIMATION:
                list = new ArrayList<Integer>();
                list.add(R.string.commonProperty);
                list.add(R.string.alpha);
                list.add(R.string.scale);
                list.add(R.string.translate);
                list.add(R.string.rotate);
                list.add(R.string.animation_set);
                list.add(R.string.interpolator1);
                list.add(R.string.layout_animation_controller);
                list.add(R.string.animation_listener);
                break;
            case Constance.VALUE_ANIMATOR:
                list = new ArrayList<>();
                list.add(R.string.value_animator_use1);
                list.add(R.string.value_animator_use2);
                list.add(R.string.value_animator_use3);
                break;
            case Constance.OBJECT_ANIMATOR:
                list = new ArrayList<>();
                list.add(R.string.object_animation_base_info);
                list.add(R.string.object_animation_principle);
                list.add(R.string.object_animation_define);
                list.add(R.string.object_animation_method);
                break;
            case Constance.PROPERTY_VALUES_HOLDER:
                list = new ArrayList<>();
                list.add(R.string.property_value_holder_info);
                list.add(R.string.property_value_holder_method);
                list.add(R.string.property_value_holder_method2);
                list.add(R.string.property_value_holder_keyframe);
                break;
            case Constance.PROPERTY_VALUES_HOLDER_KEYFRAME:
                list = new ArrayList<>();
                list.add(R.string.keyframe_base_info);
                list.add(R.string.keyframe_method);
                list.add(R.string.keyframe_method2);
                list.add(R.string.keyframe_interpolator);
                list.add(R.string.keyframe_other_info);
                break;
            case Constance.FRAME_ANIMATION:
                list = new ArrayList<>();
                list.add(R.string.animation_list);
                break;
            case Constance.ANIMATOR_SET_CODE:
                list = new ArrayList<>();
                list.add(R.string.animator_set_play_order);
                list.add(R.string.animator_set_builder);
                list.add(R.string.animator_set_listener);
                list.add(R.string.animator_set_set);
                list.add(R.string.animator_set_set_delay);
                break;
            case Constance.ANIMATOR_SET_XML:
                list = new ArrayList<>();
                list.add(R.string.animator_set_xml_common);
                list.add(R.string.animator_set_xml_animator);
                list.add(R.string.animator_set_xml_object_animator);
                list.add(R.string.animator_set_xml_set);
                list.add(R.string.animator_set_xml_sample);
                break;
            case Constance.RES:
                list = new ArrayList<>();
                list.add(R.string.anim1);
                list.add(R.string.animator);
                list.add(R.string.color);
                list.add(R.string.drawable);
                list.add(R.string.interpolator);
                list.add(R.string.layout);
                list.add(R.string.menu);
                list.add(R.string.raw);
                list.add(R.string.values);
                list.add(R.string.xml);
                break;
            case Constance.ASSETS:
                list = new ArrayList<>();
                list.add(R.string.assetManager);
                break;
            case Constance.HTTP:
                list = new ArrayList<>();
                list.add(R.string.httpConnection);
                list.add(R.string.httpClient);
                list.add(R.string.http_specialty);
                break;
            case Constance.TCP_UDP:
                list = new ArrayList<>();
                list.add(R.string.udp);
                list.add(R.string.tcp);
                list.add(R.string.udp_tcp_diff);
                break;
            case Constance.SOCKET:
                list = new ArrayList<>();
                list.add(R.string.socket_use);
                list.add(R.string.socket_tcp);
                list.add(R.string.socket_http);
                break;
            case Constance.SQLITE:
                list = new ArrayList<>();
                list.add(R.string.SQLiteOpenHelper);
                list.add(R.string.contentProvider);
                break;
            case Constance.FILE:
                list = new ArrayList<>();
                list.add(R.string.internalFile);
                list.add(R.string.externalFile);
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_OOM:
                list = new ArrayList<>();
                list.add(R.string.why_produce);
                list.add(R.string.avoid_oom);
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_IMAGE_HANDLE:
                list = new ArrayList<>();
                list.add(R.string.load_big_img);
                list.add(R.string.load_big_img2);
                list.add(R.string.photo_wall);
                list.add(R.string.fall_wall);
                list.add(R.string.multipoint_touch);
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_CACHE_MACHING:
                list = new ArrayList<>();
                list.add(R.string.ram_cache);
                list.add(R.string.file_cache);
                list.add(R.string.net_cache);
                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANR:
                list = new ArrayList<>();

                break;
            case Constance.PERFORMANCE_MEMORY_OPTIMIZE_ANALYZE:
                list = new ArrayList<>();
                list.add(R.string.heap);
                list.add(R.string.adbShall);
                list.add(R.string.dalvikLog);
                list.add(R.string.logcat1);
                list.add(R.string.mat);
                break;
            case Constance.COMMUNICATION_SAFE:
                list = new ArrayList<>();
                list.add(R.string.communicationWithService);
                list.add(R.string.communicationWithModule);
                break;
            case Constance.PHONE:
                list = new ArrayList<>();
                list.add(R.string.contactPerson);
                list.add(R.string.callHistory);
                break;
            case Constance.DESIGN_MODE:
                list = new ArrayList<>();
                list.add(R.string.singleton);
                list.add(R.string.proxy);
                list.add(R.string.builder);
                list.add(R.string.command);
                list.add(R.string.decorator);
                list.add(R.string.facade);
                list.add(R.string.observer);
                list.add(R.string.template);
                list.add(R.string.adapter);
                list.add(R.string.flyweight);
                list.add(R.string.bridge);
                list.add(R.string.composite);
                list.add(R.string.interpreter);
                list.add(R.string.mediator);
                list.add(R.string.memento);
                list.add(R.string.state);
                list.add(R.string.prototype);
                list.add(R.string.strategy);
                list.add(R.string.visitor);
                list.add(R.string.simple_factory);
                list.add(R.string.abstract_factory);
                list.add(R.string.factory_method);
                list.add(R.string.chain_of_responsibility);
                list.add(R.string.iterator);
                list.add(R.string.null_object);
                list.add(R.string.object_pool);
                list.add(R.string.private_class_data);
                break;
            default:
                list = new ArrayList<>();
                break;

        }
    }

    public List getList() {
        return list;
    }
}
