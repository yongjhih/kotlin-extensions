/*
 * Copyright (C) 2015 8tory, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlin.android.system.services

import android.accounts.AccountManager
import android.app.ActivityManager
import android.app.AlarmManager
import android.app.AppOpsManager
import android.app.DownloadManager
import android.app.KeyguardManager
import android.app.NotificationManager
import android.app.SearchManager
import android.app.UiModeManager
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.app.usage.UsageStatsManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.fingerprint.FingerprintManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.midi.MidiManager
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.BatteryManager
import android.os.DropBoxManager
import android.os.PowerManager
import android.os.UserManager
import android.os.Vibrator
import android.os.storage.StorageManager
import android.print.PrintManager
import android.service.wallpaper.WallpaperService
import android.telecom.TelecomManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager

fun Context.getActivityManager() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
fun Context.getAlarmManager() = getSystemService(Context.ALARM_SERVICE) as AlarmManager
fun Context.getAudioManager() = getSystemService(Context.AUDIO_SERVICE) as AudioManager
fun Context.getClipboardManager() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
fun Context.getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
fun Context.getKeyguardManager() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
fun Context.getLayoutInflater() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
fun Context.getLocationManager() = getSystemService(Context.LOCATION_SERVICE) as LocationManager
fun Context.getNotificationManager() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
fun Context.getPowerManager() = getSystemService(Context.POWER_SERVICE) as PowerManager
fun Context.getSearchManager() = getSystemService(Context.SEARCH_SERVICE) as SearchManager
fun Context.getSensorManager() = getSystemService(Context.SENSOR_SERVICE) as SensorManager
fun Context.getTelephonyManager() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
fun Context.getVibrator() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
fun Context.getWallpaperService() = getSystemService(Context.WALLPAPER_SERVICE) as WallpaperService
fun Context.getWifiManager() = getSystemService(Context.WIFI_SERVICE) as WifiManager
fun Context.getWindowManager() = getSystemService(Context.WINDOW_SERVICE) as WindowManager
fun Context.getInputMethodManager() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
fun Context.getAccessibilityManager() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
fun Context.getAccountManager() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
fun Context.getDevicePolicyManager() = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
fun Context.getDropBoxManager() = getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager
fun Context.getUiModeManager() = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
fun Context.getDownloadManager() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
fun Context.getStorageManager() = getSystemService(Context.STORAGE_SERVICE) as StorageManager
fun Context.getNfcManager() = getSystemService(Context.NFC_SERVICE) as NfcManager
fun Context.getUsbManager() = getSystemService(Context.USB_SERVICE) as UsbManager
fun Context.getTextServicesManager() = getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager
fun Context.getWifiP2pManager() = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
fun Context.getInputManager() = getSystemService(Context.INPUT_SERVICE) as InputManager
fun Context.getMediaRouter() = getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter
fun Context.getNsdManager() = getSystemService(Context.NSD_SERVICE) as NsdManager
fun Context.getDisplayManager() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
fun Context.getUserManager() = getSystemService(Context.USER_SERVICE) as UserManager
fun Context.getBluetoothManager() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
fun Context.getAppOpsManager() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
fun Context.getCaptioningManager() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager
fun Context.getConsumerIrManager() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager
fun Context.getPrintManager() = getSystemService(Context.PRINT_SERVICE) as PrintManager
fun Context.getAppWidgetManager() = getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager
fun Context.getBatteryManager() = getSystemService(Context.BATTERY_SERVICE) as BatteryManager
fun Context.getCameraManager() = getSystemService(Context.CAMERA_SERVICE) as CameraManager
fun Context.getJobScheduler() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
fun Context.getLauncherApps() = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
fun Context.getMediaProjectionManager() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
fun Context.getMediaSessionManager() = getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager
fun Context.getRestrictionsManager() = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager
fun Context.getTelecomManager() = getSystemService(Context.TELECOM_SERVICE) as TelecomManager
fun Context.getTvInputManager() = getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager
fun Context.getSubscriptionManager() = getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
fun Context.getUsageStatsManager() = getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
fun Context.getCarrierConfigManager() = getSystemService(Context.CARRIER_CONFIG_SERVICE) as CarrierConfigManager
fun Context.getFingerprintManager() = getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager
fun Context.getMidiManager() = getSystemService(Context.MIDI_SERVICE) as MidiManager
fun Context.getNetworkStatsManager() = getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager
/*
inline fun Context.activityManager() = getSystemService(ActivityManager.class)
inline fun Context.alarmManager() = getSystemService(AlarmManager.class)
inline fun Context.audioManager() = getSystemService(AudioManager.class)
inline fun Context.clipboardManager() = getSystemService(ClipboardManager.class)
inline fun Context.connectivityManager() = getSystemService(ConnectivityManager.class)
inline fun Context.keyguardManager() = getSystemService(KeyguardManager.class)
inline fun Context.layoutInflater() = getSystemService(LayoutInflater.class)
inline fun Context.locationManager() = getSystemService(LocationManager.class)
inline fun Context.notificationManager() = getSystemService(NotificationManager.class)
inline fun Context.powerManager() = getSystemService(PowerManager.class)
inline fun Context.searchManager() = getSystemService(SearchManager.class)
inline fun Context.sensorManager() = getSystemService(SensorManager.class)
inline fun Context.telephonyManager() = getSystemService(TelephonyManager.class)
inline fun Context.vibrator() = getSystemService(Vibrator.class)
inline fun Context.wallpaperService() = getSystemService(WallpaperService.class)
inline fun Context.wifiManager() = getSystemService(WifiManager.class)
inline fun Context.windowManager() = getSystemService(WindowManager.class)
inline fun Context.inputMethodManager() = getSystemService(InputMethodManager.class)
inline fun Context.accessibilityManager() = getSystemService(AccessibilityManager.class)
inline fun Context.accountManager() = getSystemService(AccountManager.class)
inline fun Context.devicePolicyManager() = getSystemService(DevicePolicyManager.class)
inline fun Context.dropBoxManager() = getSystemService(DropBoxManager.class)
inline fun Context.uiModeManager() = getSystemService(UiModeManager.class)
inline fun Context.downloadManager() = getSystemService(DownloadManager.class)
inline fun Context.storageManager() = getSystemService(StorageManager.class)
inline fun Context.nfcManager() = getSystemService(NfcManager.class)
inline fun Context.usbManager() = getSystemService(UsbManager.class)
inline fun Context.textServicesManager() = getSystemService(TextServicesManager.class)
inline fun Context.wifiP2pManager() = getSystemService(WifiP2pManager.class)
inline fun Context.inputManager() = getSystemService(InputManager.class)
inline fun Context.mediaRouter() = getSystemService(MediaRouter.class)
inline fun Context.nsdManager() = getSystemService(NsdManager.class)
inline fun Context.displayManager() = getSystemService(DisplayManager.class)
inline fun Context.userManager() = getSystemService(UserManager.class)
inline fun Context.bluetoothManager() = getSystemService(BluetoothManager.class)
inline fun Context.appOpsManager() = getSystemService(AppOpsManager.class)
inline fun Context.captioningManager() = getSystemService(CaptioningManager.class)
inline fun Context.consumerIrManager() = getSystemService(ConsumerIrManager.class)
inline fun Context.printManager() = getSystemService(PrintManager.class)
inline fun Context.appWidgetManager() = getSystemService(AppWidgetManager.class)
inline fun Context.batteryManager() = getSystemService(BatteryManager.class)
inline fun Context.cameraManager() = getSystemService(CameraManager.class)
inline fun Context.jobScheduler() = getSystemService(JobScheduler.class)
inline fun Context.launcherApps() = getSystemService(LauncherApps.class)
inline fun Context.mediaProjectionManager() = getSystemService(MediaProjectionManager.class)
inline fun Context.mediaSessionManager() = getSystemService(MediaSessionManager.class)
inline fun Context.restrictionsManager() = getSystemService(RestrictionsManager.class)
inline fun Context.telecomManager() = getSystemService(TelecomManager.class)
inline fun Context.tvInputManager() = getSystemService(TvInputManager.class)
inline fun Context.subscriptionManager() = getSystemService(SubscriptionManager.class)
inline fun Context.usageStatsManager() = getSystemService(UsageStatsManager.class)
inline fun Context.carrierConfigManager() = getSystemService(CarrierConfigManager.class)
inline fun Context.fingerprintManager() = getSystemService(FingerprintManager.class)
inline fun Context.midiManager() = getSystemService(MidiManager.class)
inline fun Context.networkStatsManager() = getSystemService(NetworkStatsManager.class)
*/
