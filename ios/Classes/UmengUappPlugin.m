#import "UmengUappPlugin.h"
#import <UMCommon/UMCommon.h>

@implementation UmengUappPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"umeng_uapp"
            binaryMessenger:[registrar messenger]];
  UmengUappPlugin* instance = [[UmengUappPlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"init" isEqualToString:call.method]) {
      [UMConfigure initWithAppkey:call.arguments channel:@"Umeng"];
    result(@"true");
  } else {
    result(FlutterMethodNotImplemented);
  }
}

@end
