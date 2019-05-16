import 'dart:async';

import 'package:flutter/services.dart';

class UmengUapp {
  static const MethodChannel _channel = const MethodChannel('umeng_uapp');

  static Future<String> init(String appKey) async {
    final String result = await _channel.invokeMethod('init', appKey);
    return result;
  }
}
