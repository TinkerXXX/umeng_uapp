package com.fuman.flutter.umeng_uapp;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** UmengUappPlugin */
public class UmengUappPlugin implements MethodCallHandler {
  private Registrar registrar;

  UmengUappPlugin() {
    super();
  }

  private UmengUappPlugin(Registrar registrar) {
    super();
    this.registrar = registrar;
  }

  /**
   * Plugin registration.
   */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "umeng_uapp");
    channel.setMethodCallHandler(new UmengUappPlugin(registrar));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("init")) {
      String appKey = String.valueOf(call.arguments);
      UMConfigure.init(registrar.context(), appKey, "Umeng", UMConfigure.DEVICE_TYPE_PHONE, null);
      MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
      result.success("true");
    } else {
      result.notImplemented();
    }
  }
}
