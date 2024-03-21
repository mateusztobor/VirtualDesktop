import processing.sound.*;

boolean debug_mode=false;
/*
  debug_mode_location
  [1] biosloading
  [2] bios
  [3] bootmenu
  [4] login
  [5] desktop_student
  [6] desktop_prowadzacy
  [7] shutdown
*/
int debug_mode_location=4,
    student_desktop_wallpaper = 1,
    prowadzacy_desktop_wallpaper = 2,
    bios_date_day=day(),
    bios_date_month=month(),
    bios_date_year=year();

PImage desktop_wallpaper_1,
       desktop_wallpaper_2,
       desktop_wallpaper_3,
       desktop_wallpaper_4,
       desktop_mwallpaper_1,
       desktop_mwallpaper_2,
       desktop_mwallpaper_3,
       desktop_mwallpaper_4,
       os_cursor,
       os_cursor_pointer,
       os_cursor_notallowed,
       os_shutdown,
       os_logout,
       os_wifi,
       os_sound,
       login_bg,
       login_user_student,
       login_user_prowadzacy,
       login_user_gosc,
       login_shutdown,
       program_icon_calc,
       program_icon_info,
       program_icon_paint,
       program_icon_notepad,
       program_icon_wallpaper,
       us_logo;

PFont bios_logo_font,
      os_font,
      os_font_title,
      os_font_title2,
      bios_font;
      
SoundFile bios_beep;

bios_screen bios;
biosloading_screen biosloading;
bootmenu_screen bootmenu;
login_screen login;
desktop_student_screen desktop_student;
shutdown_screen shutdown;
desktop_prowadzacy_screen desktop_prowadzacy;
void setup() {
  surface.setVisible(false);
  desktop_wallpaper_4 = loadImage("src/os/wallpapers/wp-4.jpg");
  desktop_wallpaper_3 = loadImage("src/os/wallpapers/wp-3.jpg");
  desktop_wallpaper_2 = loadImage("src/os/wallpapers/wp-2.jpg");
  desktop_wallpaper_1 = loadImage("src/os/wallpapers/wp-1.jpg");
  desktop_mwallpaper_4 = loadImage("src/os/wallpapers/mwp-4.jpg");
  desktop_mwallpaper_3 = loadImage("src/os/wallpapers/mwp-3.jpg");
  desktop_mwallpaper_2 = loadImage("src/os/wallpapers/mwp-2.jpg");
  desktop_mwallpaper_1 = loadImage("src/os/wallpapers/mwp-1.jpg");
  
  //login
  login_bg = loadImage("src/os/login/login_bg.jpg");
  login_user_gosc = loadImage("src/os/login/login_user_guest.png");
  login_user_prowadzacy = loadImage("src/os/login/login_user_prowadzacy.png");
  login_user_student = loadImage("src/os/login/login_user_student.png");
  login_shutdown = loadImage("src/os/login/shutdown.png");
  
  //os
  os_font = createFont("SansSerif", 16);
  os_font_title = createFont("SansSerif", 32);
  os_font_title2 = createFont("SansSerif", 24);
  os_cursor = loadImage("src/os/cursor.png");
  os_cursor_pointer = loadImage("src/os/cursor_pointer.png");
  os_cursor_notallowed = loadImage("src/os/cursor_notallowed.png");
  os_shutdown = loadImage("src/os/desktop/shutdown.png");
  os_logout = loadImage("src/os/desktop/logout.png");
  os_wifi = loadImage("src/os/desktop/wifi.png");
  os_sound = loadImage("src/os/desktop/sound.png");
  program_icon_calc = loadImage("src/os/programs/calc.png");
  program_icon_info = loadImage("src/os/programs/info.png");
  program_icon_paint = loadImage("src/os/programs/paint.png");
  program_icon_notepad = loadImage("src/os/programs/notepad.png");
  program_icon_wallpaper = loadImage("src/os/programs/wallpaper.png");
  us_logo = loadImage("src/os/us_logo.png");
  
  //bios
  bios_beep = new SoundFile(this, "src/bios/bios_beep.mp3");
  bios_logo_font = createFont("src/bios/bios_logo_font.ttf", 64);
  bios_font = createFont("SansSerif", 16);
  surface.setVisible(false);
  if(debug_mode && debug_mode_location > 1 && debug_mode_location <= 7) {
    if(debug_mode_location == 2) bios = new bios_screen();
    else if(debug_mode_location == 3) bootmenu = new bootmenu_screen();
    else if(debug_mode_location == 4) login = new login_screen();
    else if(debug_mode_location == 5) desktop_student = new desktop_student_screen();
    else if(debug_mode_location == 6) desktop_prowadzacy = new desktop_prowadzacy_screen();
    else if(debug_mode_location == 7) shutdown = new shutdown_screen();
  } else biosloading = new biosloading_screen();
}

void draw() {}
