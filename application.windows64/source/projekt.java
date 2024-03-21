import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class projekt extends PApplet {



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
public void setup() {
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

public void draw() {}
class bios_screen extends PApplet {
  bios_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  public void settings() {
    size(1280, 720);
    
  }
  String hour,minute,day,month,sec;
  public void setup() {
    frameRate(30);
    surface.setTitle("Virtual Desktop - BIOS");
    noCursor();
    if(hour()<10) hour = "0" + hour();
    else hour = "" + hour();
    if(minute()<10) minute = "0" + minute();
    else minute = "" + minute();
    if(bios_date_day < 10) day="0"+bios_date_day;
    else day="" + bios_date_day;
    if(bios_date_month < 10) month="0"+bios_date_month;
    else month="" + bios_date_month;
    if(second() < 10) sec="0"+second();
    else sec="" + second();
  }
  public void draw() {
    background(0,0,139);
    fill(255);
    text("[F1] Discard changes and restart        [F2] Save changes and restart", 10, height-30);
    textFont(bios_logo_font);
    
    
    text("VIRTUAL BIOS", width-500, height-30);
    textFont(bios_font);
    fill(150);
    text("Manufactured: Virtual Desktop", 10, 20);
    text("Brand string: Virtual(R) Core", 10, 40);
    text("Frequency: 600MHz", 10, 60);
    text("BLCK Speed: 166MHz", 10, 80);
    text("Cache L1: 32 KB", 10, 100);
    text("Cache L2: 128 KB", 10, 120);
    
    text("Bios Version: 01.00.00", 10, 180);
    text("BIOS Date "+day+"/"+month+"/"+year()+" "+hour+":"+minute+":"+sec, 10, 200);
    
    text("Memory: 65536K", 10, 260);
    text("Memory Clock: 166MHz", 10, 280);
    
    if(debug_mode) {
      text ("DEBUG MODE", width-200, 40);
      text ("Mouse: " + mouseX + ", " + mouseY, width-200, 60);
      text ("Key: " + key + ", " + keyCode, width-200, 80);
    }
  }
  public void keyPressed() {
    if(keyCode>=112 && keyCode <= 123) bios_beep.play();
    //obsluga przyciskow
    if(keyCode==112 || keyCode==113) {
      delay(2000);
      surface.setVisible(false);
      biosloading = new biosloading_screen();
    }
  }
}
class biosloading_screen extends PApplet {
  boolean ok_run=false;
  biosloading_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  public void settings() {
    size(1280, 720);
    
  }
  String hour,minute,day,month,sec;
  public void setup() {
    frameRate(30);
    surface.setTitle("Virtual Desktop - Loading BIOS");
    noCursor();
    if(hour()<10) hour = "0" + hour();
    else hour = "" + hour();
    if(minute()<10) minute = "0" + minute();
    else minute = "" + minute();
    if(bios_date_day < 10) day="0"+bios_date_day;
    else day="" + bios_date_day;
    if(bios_date_month < 10) month="0"+bios_date_month;
    else month="" + bios_date_month;
    if(second() < 10) sec="0"+second();
    else sec="" + second();
  }
    


  public void draw() {
    int timer_start, timer_end;
    background(0,0,0);
    //textSize(11);
    textFont(bios_logo_font);
    text("VIRTUAL DESKTOP", 10, 60);
    textFont(bios_font);
    text("by Mateusz Tobor", 480, 80);
    text("Virtual Motherboard, Inc.", 10, 130);
    text("Virtual Motherboard, Inc.", 10, 130);
    text("BIOS Date "+day+"/"+month+"/"+year()+" "+hour+":"+minute+":"+sec+" Ver: 01.00.00", 10, 150);
    timer_start = 0;timer_end = 500;
    if (millis() - timer_start > timer_end) {
      text("CPU: Virtual CPU", 10, 170);
      text("Speed: 600MHz", 10, 190);
    }
    timer_start = 0;timer_end = 2000;
    if (millis() - timer_start > timer_end) {
      text("CPU Test: OK", 10, 210);
    }
    timer_start = 0;timer_end = 4000;
    if (millis() - timer_start > timer_end) {
      text("Memory: 65536K", 10, 230);
      text("Memory Clock: 166MHz", 10, 250);
    }
    timer_start = 0;timer_end = 7000;
    if (millis() - timer_start > timer_end) {
      text("Memory Test: OK", 10, 270);
    }
    timer_start = 0;timer_end = 10000;
    if (millis() - timer_start > timer_end) {
      text("USB Device(s): 1 Keyboard, 1 Mouse", 10, 290);
    }
    timer_start = 0;timer_end = 11000;
    if (millis() - timer_start > timer_end) {
      text("Select Option:", 10, 330);
      text("[SPACE] BOOT OS               [F2] BIOS SETUP               [F11] BOOT MENU               [F12] SHUTDOWN", 10, 350);
      
      ok_run=true;
    }
    if(debug_mode) {
      text ("DEBUG MODE", width-200, 40);
      text ("Mouse: " + mouseX + ", " + mouseY, width-200, 60);
      text ("Key: " + key + ", " + keyCode, width-200, 80);
    }
  }
  
  public void keyPressed() {
    if(keyCode>=112 && keyCode <= 123) bios_beep.play();
    if(ok_run) {
      //obsluga przyciskow
      if(keyCode==123) exit();
      else if(keyCode==113) {
        surface.setVisible(false);
        bios = new bios_screen();  //obsługa f2
      }
      else if(keyCode==122) {
        surface.setVisible(false);
        bootmenu = new bootmenu_screen();  //obsługa f12
      }
      else if(keyCode==32) {
        surface.setVisible(false);
        login = new login_screen();
      }
    }
  }
}
class bootmenu_screen extends PApplet {
  bootmenu_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }

  public void settings() {
    size(1280, 720);
  }

  public void setup() {
    frameRate(30);
    noCursor();
    surface.setTitle("Virtual Desktop - BOOT MENU");
  }

int boot_warning=-220;

  public void draw() {
    background(0,0,0);
    //textSize(11);
    textFont(bios_logo_font);
    text("VIRTUAL DESKTOP", 10, 60);
    PFont bios_font_title = createFont("SansSerif", 24);
    PFont bios_font = createFont("SansSerif", 16);
    textFont(bios_font_title);
    text("BOOT MENU", 10, 130);
    textFont(bios_font);
    text("by Mateusz Tobor", 480, 80);
    text("[F1] Hard Drive (Virtual HDD)", 10, 150);
    text("[F2] Floppy Disk (no detected)", 10, 170);
    text("[F3] USB Storage (no detected)", 10, 190);
    text("Warning: not detected booting option!", 10, boot_warning);
    if(debug_mode) {
      text ("DEBUG MODE", width-200, 40);
      text ("Mouse: " + mouseX + ", " + mouseY, width-200, 60);
      text ("Key: " + key + ", " + keyCode, width-200, 80);
    }
  }
  
  public void keyPressed() {
    if(keyCode>=112 && keyCode <= 123) bios_beep.play();
    if(keyCode==113 || keyCode==114) boot_warning=220;
    else if(keyCode==112) {
      surface.setVisible(false);
      login = new login_screen();
    }
  }
}
class desktop_student_screen extends PApplet {
  desktop_student_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  
  public void settings() {
    size(1280, 720);
  }

  public void setup() {
    frameRate(30);
    cursor(os_cursor);
    surface.setTitle("Virtual Desktop - Logged as Student");
  }
  
  String program_title="NONE";
  boolean program=false,
          program_calc=false,
          program_info=false,
          program_paint=false,
          program_notepad=false,
          program_wifi=false,
          program_sound=false,
          program_wallpaper=false;
            
public void draw() {
    setWallpaper(student_desktop_wallpaper); 
    new_icon(1,1,8,program_icon_calc,"Kalkulator",2);
    new_icon(4,1,5,program_icon_info,"O systemie",1);
    new_icon(1,2,27,program_icon_paint,"Paint",3);
    new_icon(1,3,15,program_icon_notepad,"Notatnik",4);
    new_icon(1,6,-1,program_icon_wallpaper,"Zmień tapetę",5);
    if(program) {
      program_new_window();
      if(program_calc) app_calc();
      else if(program_info) app_info();
      else if(program_paint) app_paint();
      else if(program_notepad) app_notepad();
      else if(program_wifi) app_wifi();
      else if(program_sound) app_sound();
      else if(program_wallpaper) app_wallpaper();
    }
    nav();
    if(debug_mode) {
      fill(255,255,255);
      textFont(os_font);
      text ("DEBUG MODE", width-200, 40);
      text ("Mouse: " + mouseX + ", " + mouseY, width-200, 60);
      text ("Key: " + key + ", " + keyCode, width-200, 80);
    }
  }
  public void app_wallpaper() {
    fill(200,200,200);  
    if(mouseX >= 20 && mouseY >= 120 && mouseX <= 376 && mouseY <= 320) {
      rect(10,110,376,220);
      if(mousePressed) student_desktop_wallpaper=1;
    }
    else if(mouseX >= 366 && mouseY >= 120 && mouseX <= 742 && mouseY <= 320) {
      rect(376,110,376,220);
      if(mousePressed) student_desktop_wallpaper=2;
    }
    else if(mouseX >= 752 && mouseY >= 120 && mouseX <= 1118 && mouseY <= 320) {
      rect(742,110,376, 220);
      if(mousePressed) student_desktop_wallpaper=3;
    }
    else if(mouseX >= 20 && mouseY >= 230 && mouseX <= 376 && mouseY <= 530) {
      rect(10,320,376,220);
      if(mousePressed) student_desktop_wallpaper=4;
    }
    image(desktop_mwallpaper_1, 20,120);
    image(desktop_mwallpaper_2, 386,120);
    image(desktop_mwallpaper_3, 752,120);
    image(desktop_mwallpaper_4, 20,330);

  }
  public void app_wifi() {
    text("Wifi zostało wyłączone przez administratora systemu.",20,120);
  }
  public void app_sound() {
    text("Wystąpił problem ze sterownikiem dźwięku. Skontaktuj się z administratorem systemu.",20,120);
  }
  
  String app_notepad_input="";
  public void app_notepad() {
    text(app_notepad_input+"|",20,120);
  }
  public void app_paint() {
    text("Program Paint uległ awarii.",20,120);
  }
  public void app_info() {
    fill(0,0,0);
    textFont(bios_logo_font);
    text ("VIRTUAL DESKTOP", 20, 170);
    textFont(os_font);
    text ("Projekt wykonany przez Mateusza Tobor.", 20, 210);
    textFont(os_font_title2);
    text ("Źródła wykorzystanych materiałów:", 20, 250);
    textFont(os_font);
    text ("https://www.1001fonts.com/vt323-font.html", 20, 270);
    text ("https://icon-icons.com/download/45849/PNG/32/", 20, 290);
    text ("https://www.pngegg.com/en/png-zkxjq", 20, 310);
    text ("https://www.iconfinder.com/icons/285631/notepad_icon", 20, 330);
    text ("https://pngimg.com/image/33824", 20, 350);
    text ("https://pl.pngtree.com/free-png-vectors/profesor", 20, 370);
    text ("https://pl.pinterest.com/pin/666532813593604948/", 20, 390);
    text ("https://www.fontspace.com/men-in-blue-font-f2258", 20, 410);
    text ("https://512pixels.net/projects/default-mac-wallpapers-in-5k/", 20, 430);
    text ("https://www.soundjay.com/beep-sounds-1.html", 20, 450);
    text ("https://www.flaticon.com/free-icon/shut-down-icon_63769", 20, 470);
    text ("https://wallpaperaccess.com/old-mac", 20, 490);
    text ("https://szl.m.wikipedia.org/wiki/Plik:Information_icon.svg", 20, 510);
    text ("https://winaero.com/more-colorful-windows-10-icons-this-time-it-is-calculator/", 20, 530);
    text ("http://cursor.in", 20, 550);
    text ("https://commons.wikimedia.org/wiki/File:OOjs_UI_icon_logOut-ltr.svg", 20, 570);
    text ("https://www.flaticon.com/free-icon/no-wifi_2313867", 20, 590);
    text ("https://www.subpng.com/png-wdplhz/", 20, 610);
    text ("https://www.amazon.com/QConnect-Slide-Show-Maker-Pro/dp/B00I9Q3XJW", 20, 630);
    image(us_logo, width-500, 60);
  }
  
  String app_calc_a="",app_calc_b="",app_calc_c="",app_calc_result="";
  boolean app_calc_a_s=false,app_calc_b_s=false,app_calc_dot=false,app_calc_r=false;
  public void app_calc() {
    textFont(os_font_title);
    fill(0,0,0);
    text(app_calc_a + app_calc_b + app_calc_c + app_calc_result,20,150);
    //+
    if(mouseX >= 525 && mouseY >=210 && mouseX <= 625 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(525,210, 100, 100);
    fill(255,255,255);
    text("+",565,270);
    
    //1
    if(mouseX >= 630 && mouseY >=210 && mouseX <= 730 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(630,210, 100, 100);
    fill(255,255,255);
    text("1",670,270);
    
    //2
    if(mouseX >= 735 && mouseY >=210 && mouseX <= 835 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(735,210, 100, 100);
    fill(255,255,255);
    text("2",775,270);
    
    //3
    if(mouseX >= 840 && mouseY >=210 && mouseX <= 940 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(840, 210, 100, 100);
    fill(255,255,255);
    text("3",880,270);
    
    //---------------------
    
    //-
    if(mouseX >= 525 && mouseY >=315 && mouseX <= 625 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(525,315, 100, 100);
    fill(255,255,255);
    text("-",570,375);
    
    
    //4
    if(mouseX >= 630 && mouseY >=315 && mouseX <= 730 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(630,315, 100, 100);
    fill(255,255,255);
    text("4",670,375); 
    
    //5
    if(mouseX >= 735 && mouseY >=315 && mouseX <= 835 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(735,315, 100, 100);
    fill(255,255,255);
    text("5",775,375);
    
    //6
    if(mouseX >= 840 && mouseY >=315 && mouseX <= 940 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(840, 315, 100, 100);
    fill(255,255,255);
    text("6",880,375);
    
    //-----------------------------------------------
    
    //*
    if(mouseX >= 525 && mouseY >=420 && mouseX <= 625 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(525,420, 100, 100);
    fill(255,255,255);
    text("*",570,490);
    
    //7
    if(mouseX >= 630 && mouseY >=420 && mouseX <= 730 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(630,420, 100, 100);
    fill(255,255,255);
    text("7",670,480);
    
    //8
    if(mouseX >= 735 && mouseY >=420 && mouseX <= 835 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(735,420, 100, 100);
    fill(255,255,255);
    text("8",775,480);
    
    //9
    if(mouseX >= 840 && mouseY >=420 && mouseX <= 940 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(840,420, 100, 100);
    fill(255,255,255);
    text("9",880,480);
    
    //---------------------------------------------------------
    // C
    if(mouseX >= 420 && mouseY >=525 && mouseX <= 520 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(420,525, 100, 100);
    fill(255,255,255);
    text("C",460,585);
    
    
    // /
    if(mouseX >= 525 && mouseY >=525 && mouseX <= 625 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(525,525, 100, 100);
    fill(255,255,255);
    text("/",570,585);
    
    
    // .
    if(mouseX >= 630 && mouseY >=525 && mouseX <= 730 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(630,525, 100, 100);
    fill(255,255,255);
    text(".",675,585);
    
    // 0
    if(mouseX >= 735 && mouseY >=525 && mouseX <= 835 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(735,525, 100, 100);
    fill(255,255,255);
    text("0",775,585);
    
    // =
    if(mouseX >= 840 && mouseY >=525 && mouseX <= 940 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(840, 525, 100, 100);
    fill(255,255,255);
    text("=",880,585);
  }

  public void mousePressed() {
    if(mouseX >= 44 && mouseY >= 4 && mouseX <= 72 && mouseY <= 32) {
      delay(5000);
      surface.setVisible(false);
      login = new login_screen();
    }
    else if(mouseX >= 6 && mouseY >= 4 && mouseX <= 34 && mouseY <= 32) {
      surface.setVisible(false);
      shutdown = new shutdown_screen();
    }
    else if(mouseX >= 1100 && mouseY >= 4 && mouseX <= 1128 && mouseY <= 32) {
      close_program();
      program=true;
      program_title="Ustawienia WIFI";
      program_wifi=true;
      
    }
    else if(mouseX >= 1060 && mouseY >= 4 && mouseX <= 1088 && mouseY <= 32) {
      close_program();
      program=true;
      program_title="Ustawienia dźwięku";
      program_sound=true;
    }
    if(program) {
      if(mouseButton == LEFT) {
        if(mouseX >= 1210 && mouseY >= 68 && mouseX <= 1265 && mouseY <= 100) close_program();
        if(program_calc) {
          if(!app_calc_r) {
            if(mouseX >= 525 && mouseY >=210 && mouseX <= 625 && mouseY <= 310) {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="+";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 1
            else if(mouseX >= 630 && mouseY >=210 && mouseX <= 730 && mouseY <= 310) {
               if(!app_calc_b_s) {
                 app_calc_a+="1";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="1";
                 app_calc_result="";
               }
            }
            //obsluga 2
            else if(mouseX >= 735 && mouseY >=210 && mouseX <= 835 && mouseY <= 310) {
               if(!app_calc_b_s) {
                 app_calc_a+="2";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="2";
                 app_calc_result="";
               }
            }
            //obsluga 3
            else if(mouseX >= 840 && mouseY >=210 && mouseX <= 940 && mouseY <= 310) {
               if(!app_calc_b_s) {
                 app_calc_a+="3";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="3";
                 app_calc_result="";
               }
            }
            //obsluga -
            else if(mouseX >= 525 && mouseY >=315 && mouseX <= 625 && mouseY <= 415) {
              if(app_calc_a_s && app_calc_b_s &&  app_calc_c.equals("") && !app_calc_c.equals("-")) {
                app_calc_c+="-";
              }
              else if(app_calc_a_s) {
                   if(app_calc_b.equals("")) app_calc_dot=false;
                   app_calc_b="-";
                   app_calc_b_s=true;
                   app_calc_result="";
               } else if(app_calc_a.equals("") && !app_calc_a.equals("-")){
                 app_calc_a+="-";
               }
            }
            //obsluga 4
            else if(mouseX >= 630 && mouseY >=315 && mouseX <= 730 && mouseY <= 415) {
               if(!app_calc_b_s) {
                 app_calc_a+="4";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="4";
                 app_calc_result="";
               }
            }
            //obsluga 5
            else if(mouseX >= 735 && mouseY >=315 && mouseX <= 835 && mouseY <= 415) {
               if(!app_calc_b_s) {
                 app_calc_a+="5";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="5";
                 app_calc_result="";
               }
            }
            //obsluga 6
            else if(mouseX >= 840 && mouseY >=315 && mouseX <= 940 && mouseY <= 415) {
               if(!app_calc_b_s) {
                 app_calc_a+="6";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="6";
                 app_calc_result="";
               }
            }
            //obsluga *
            else if(mouseX >= 525 && mouseY >=420 && mouseX <= 625 && mouseY <= 520) {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="*";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 7
            else if(mouseX >= 630 && mouseY >=420 && mouseX <= 730 && mouseY <= 520) {
               if(!app_calc_b_s) {
                 app_calc_a+="7";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="7";
                 app_calc_result="";
               }
            }
            //obsluga 8
            else if(mouseX >= 735 && mouseY >=420 && mouseX <= 835 && mouseY <= 520) {
               if(!app_calc_b_s) {
                 app_calc_a+="8";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="8";
                 app_calc_result="";
               }
            }
            //obsluga 9
            else if(mouseX >= 840 && mouseY >=420 && mouseX <= 940 && mouseY <= 520) {
               if(!app_calc_b_s) {
                 app_calc_a+="9";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="9";
                 app_calc_result="";
               }
            }
            //obsluga /
            else if(mouseX >= 525 && mouseY >=525 && mouseX <= 625 && mouseY <= 625) {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="/";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 0
            else if(mouseX >= 735 && mouseY >=525 && mouseX <= 835 && mouseY <= 625) {
               if(!app_calc_b_s) {
                 app_calc_a+="0";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="0";
                 app_calc_result="";
               }
            }
            //obsluga .
            else if(mouseX >= 630 && mouseY >=525 && mouseX <= 730 && mouseY <= 625) {
               if(!app_calc_dot) {
                 if(!app_calc_b_s) {
                   app_calc_a+=".";
                   app_calc_a_s=true;
                   app_calc_result="";
                 } else {
                   app_calc_c+=".";
                   app_calc_result="";
                 }
                 app_calc_dot=true;
               }
            }
            
            //obsluga =
            else if(mouseX >= 840 && mouseY >=525 && mouseX <= 940 && mouseY <= 625) {
               if(!app_calc_a.equals("")) {
                 if(app_calc_c.equals("")) {
                   app_calc_result = "=" + app_calc_a + "";
                 } else {
                   //app_calc_result = new String ( (int)app_calc_a + (int)app_calc_c);
                   float a=0;
                   
                   if(app_calc_b.equals("+")) a = Float.valueOf(app_calc_a) + Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("-")) a = Float.valueOf(app_calc_a) - Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("/")) {
                     if(Float.valueOf(app_calc_c) != 0)
                     a = Float.valueOf(app_calc_a) / Float.valueOf(app_calc_c);
                     else a=0;
                   }
                   else if(app_calc_b.equals("*")) a = Float.valueOf(app_calc_a) * Float.valueOf(app_calc_c);
                   app_calc_result = "=" + (float)a + "";
                   app_calc_r=true;
                 }
               }
            }
          }
          
          //obsluga C
          if(mouseX >= 420 && mouseY >=525 && mouseX <= 520 && mouseY <= 625) {
             if(app_calc_a_s) {
               app_calc_a="";
               app_calc_b="";
               app_calc_c="";
               app_calc_a_s=false;
               app_calc_b_s=false;
               app_calc_dot=false;
               app_calc_r=false;
               app_calc_result="";
             }
          }
        }
      }
    }
  }
  
  public void keyPressed() {
    if(program) {
      if(program_notepad) {
        if(key == 'q' || key == 'w' || key == 'e' || key == 'r' || key == 't' || key == 'y' || key == 'u' || key == 'i' || key == 'o' || key == 'p' || key == '[' ||  key == ']' || 
        key == 'a' || key == 's' || key == 'd' || key == 'f' || key == 'g' || key == 'h' || key == 'j' || key == 'k' || key == 'l' || key == ';' || 
        key == 'z' || key == 'x' || key == 'c' || key == 'v' || key == 'b' || key == 'n' || key == 'm' || key == ',' || key == '.' ||
        key == 'ż' || key == 'ą' || key == 'ę' || key == 'ć' || key == 'ź' || key == 'ł' || key == 'ó' || key == '?' || key == '!' ||  
        key == 'Q' || key == 'W' || key == 'E' || key == 'R' || key == 'T' || key == 'Y' || key == 'U' || key == 'I' || key == 'O' || key == 'P' ||
        key == 'A' || key == 'S' || key == 'D' || key == 'F' || key == 'G' || key == 'H' || key == 'J' || key == 'K' || key == 'L' ||
        key == 'Z' || key == 'X' || key == 'C' || key == 'V' || key == 'B' || key == 'N' || key == 'M' ||
        key == 'Ż' || key == 'Ą' || key == 'Ę' || key == 'Ć' || key == 'Ź' || key == 'Ł' || key == 'Ó' ||
        key == '1' || key == '2' || key == '3' || key == '4' || key == '5' || key == '6' || key == '7' || key == '8' || key == '9' || key == '0' || keyCode == 10  || keyCode == 32 ||
        key == '@' || key == '#' || key == '$' || key == '%' || key == '^' || key == '&' || key == '*' || key == '(' || key == ')' || keyCode == 222 || key == '<' || key == '>' ||
        key == '"' || key == '|'  || keyCode == 92 || key == '{' || key == '}' || key == '_'  || key == '+' || key == ':'
        )
        app_notepad_input+=key;
        if(keyCode == 8) {
          if(app_notepad_input.length()>0) app_notepad_input=app_notepad_input.substring(0,app_notepad_input.length()-1);
        }
      }
      if(program_calc) {
        if(!app_calc_r) {
           if(key=='+') {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="+";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 1
            else if(key=='1') {
               if(!app_calc_b_s) {
                 app_calc_a+="1";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="1";
                 app_calc_result="";
               }
            }
            //obsluga 2
            else if(key=='2') {
               if(!app_calc_b_s) {
                 app_calc_a+="2";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="2";
                 app_calc_result="";
               }
            }
            //obsluga 3
            else if(key=='3') {
               if(!app_calc_b_s) {
                 app_calc_a+="3";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="3";
                 app_calc_result="";
               }
            }
            //obsluga -
            else if(key=='-') {
              if(app_calc_a_s && app_calc_b_s &&  app_calc_c.equals("")) {
                app_calc_c+="-";
              }
              else {
                if(app_calc_a_s) {
                   if(app_calc_b.equals("")) app_calc_dot=false;
                   app_calc_b="-";
                   app_calc_b_s=true;
                   app_calc_result="";
                 } else {
                   app_calc_a+="-";
                 }
              }
            }
            //obsluga 4
            else if(key=='4') {
               if(!app_calc_b_s) {
                 app_calc_a+="4";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="4";
                 app_calc_result="";
               }
            }
            //obsluga 5
            else if(key=='5') {
               if(!app_calc_b_s) {
                 app_calc_a+="5";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="5";
                 app_calc_result="";
               }
            }
            //obsluga 6
            else if(key=='6') {
               if(!app_calc_b_s) {
                 app_calc_a+="6";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="6";
                 app_calc_result="";
               }
            }
            //obsluga *
            else if(key=='*') {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="*";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 7
            else if(key=='7') {
               if(!app_calc_b_s) {
                 app_calc_a+="7";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="7";
                 app_calc_result="";
               }
            }
            //obsluga 8
            else if(key=='8') {
               if(!app_calc_b_s) {
                 app_calc_a+="8";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="8";
                 app_calc_result="";
               }
            }
            //obsluga 9
            else if(key=='9') {
               if(!app_calc_b_s) {
                 app_calc_a+="9";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="9";
                 app_calc_result="";
               }
            }
            //obsluga /
            else if(key=='/') {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="/";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 0
            else if(key=='0') {
               if(!app_calc_b_s) {
                 app_calc_a+="0";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="0";
                 app_calc_result="";
               }
            }
            //obsluga .
            else if(key=='.') {
               if(!app_calc_dot) {
                 if(!app_calc_b_s) {
                   app_calc_a+=".";
                   app_calc_a_s=true;
                   app_calc_result="";
                 } else {
                   app_calc_c+=".";
                   app_calc_result="";
                 }
                 app_calc_dot=true;
               }
            }
            
            //obsluga =
            else if(key=='=' || keyCode==10) {
               if(!app_calc_a.equals("")) {
                 if(app_calc_c.equals("")) {
                   app_calc_result = "=" + app_calc_a + "";
                 } else {
                   //app_calc_result = new String ( (int)app_calc_a + (int)app_calc_c);
                   float a=0;
                   
                   if(app_calc_b.equals("+")) a = Float.valueOf(app_calc_a) + Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("-")) a = Float.valueOf(app_calc_a) - Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("/")) {
                     if(Float.valueOf(app_calc_c) != 0)
                     a = Float.valueOf(app_calc_a) / Float.valueOf(app_calc_c);
                     else a=0;
                   }
                   else if(app_calc_b.equals("*")) a = Float.valueOf(app_calc_a) * Float.valueOf(app_calc_c);
                   app_calc_result = "=" + (float)a + "";
                   app_calc_r=true;
                 }
               }
            }
        }
        //obsluga C
        else if(key=='c' || key=='C') {
           if(app_calc_a_s) {
             app_calc_a="";
             app_calc_b="";
             app_calc_c="";
             app_calc_a_s=false;
             app_calc_b_s=false;
             app_calc_dot=false;
             app_calc_r=false;
             app_calc_result="";
           }
        }
      }
    }
  }
  
  public void new_icon(int x, int y, int p, PImage icon, String title, int app_id) {
    --x;--y;
    x*=110;y*=110;
    if(!program) {
      if(mouseX >= x+10 && mouseY >= y+60 && mouseX <= x+110 && mouseY <= y+160) {
        fill(255,255,255,100);
        if(mousePressed && mouseButton == LEFT) {
          program=true;
          program_title=title;
          program_run(app_id);
        }
      }
      else fill(255,255,255,30);
    } else fill(255,255,255,30);
    noStroke();
    rect(x+10,y+60,100,100,10);
    image(icon, PApplet.parseFloat(x+27),PApplet.parseFloat(y+70));
    fill(255,255,255);
    textFont(os_font);
    text(title, PApplet.parseFloat(x+15+p), PApplet.parseFloat(y+155));
  }
  
  public void nav() {
    fill(0,0,0);
    rect(0,0,width,40,0, 0, 10, 10);
    textFont(os_font);
    fill(255,255,255);
    String hour,minute,day,month;
    if(hour()<10) hour = "0" + hour();
    else hour = "" + hour();
    if(minute()<10) minute = "0" + minute();
    else minute = "" + minute();
    if(bios_date_day < 10) day="0"+bios_date_day;
    else day="" + bios_date_day;
    if(bios_date_month < 10) month="0"+bios_date_month;
    else month="" + bios_date_month;
    text(day + "." + month + "." + bios_date_year, 1145, 25);
    text(hour + ":" + minute , 1230, 25);
    text("Zalogowany jako Student", 550, 25);
    text("PL", 1030, 25);
    
    if(mouseX >= 6 && mouseY >= 4 && mouseX <= 34 && mouseY <= 32) cursor(os_cursor_pointer);
    else if(mouseX >= 44 && mouseY >= 4 && mouseX <= 72 && mouseY <= 32) cursor(os_cursor_pointer);
    else if(mouseX >= 1100 && mouseY >= 4 && mouseX <= 1128 && mouseY <= 32) cursor(os_cursor_pointer);
    else if(mouseX >= 1060 && mouseY >= 4 && mouseX <= 1088 && mouseY <= 32) cursor(os_cursor_pointer);
    else cursor(os_cursor);
    image(os_shutdown, 6, 4);
    image(os_logout, 44, 4);
    image(os_wifi, 1100, 4);
    image(os_sound, 1060, 4);
  }
  
  public void close_program() {
    program=false;
    //dalsze opcje wyłączenia...
    if(program_calc) {
       app_calc_a="";
       app_calc_b="";
       app_calc_c="";
       app_calc_a_s=false;
       app_calc_b_s=false;
       app_calc_dot=false;
       app_calc_r=false;
       app_calc_result="";
       program_calc=false;
    }
    program_info=false;
    program_paint=false;
    program_notepad=false;
    program_wifi=false;
    program_sound=false;
    program_wallpaper=false;
  }
  
  public void program_new_window() {
    program=true;
    fill(255,255,255,200);
    rect(10,60, 1260, 40);
    fill(255,255,255);
    rect(10,100, width-20, height-120);
    int program_close_light;
    if(mouseX >= 1210 && mouseY >= 68 && mouseX <= 1265 && mouseY <= 100) program_close_light=255;
    else program_close_light=128;
    fill(program_close_light,0,0);
    rect(width-70,63, 57, 34);
    fill(255,255,255);
    textFont(os_font_title2);
    text("X", 1231, 90);
    textFont(os_font);
    fill(0,0,0);
    text(program_title, 20,85);
  }
  
  public void program_run(int app) {
    if(app == 1) program_info = true;
    else if(app == 2) program_calc = true;
    else if(app == 3) program_paint = true;
    else if(app == 4) program_notepad = true;
    else if(app == 5) program_wallpaper= true;
    
  }

  public void setWallpaper(int wallpaper) {
    if(wallpaper==1)
      background(desktop_wallpaper_1);
    else if(wallpaper==2)
      background(desktop_wallpaper_2);
    else if(wallpaper==3)
      background(desktop_wallpaper_3);
    else if(wallpaper==4)
      background(desktop_wallpaper_4);
    else background(105,104,182);
  }
}
class desktop_prowadzacy_screen extends PApplet {
  desktop_prowadzacy_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  
  public void settings() {
    size(1280, 720);
  }

  public void setup() {
    frameRate(30);
    cursor(os_cursor);
    surface.setTitle("Virtual Desktop - Logged as Prowadzący");
  }
  
  String program_title="NONE";
  boolean program=false,
          program_calc=false,
          program_info=false,
          program_paint=false,
          program_notepad=false,
          program_wifi=false,
          program_sound=false,
          program_wallpaper=false;
            
public void draw() {
    setWallpaper(prowadzacy_desktop_wallpaper); 
    new_icon(3,1,8,program_icon_calc,"Kalkulator",2);
    new_icon(7,5,5,program_icon_info,"O systemie",1);
    new_icon(4,1,15,program_icon_notepad,"Notatnik",4);
    new_icon(8,5,-1,program_icon_wallpaper,"Zmień tapetę",5);
    if(program) {
      program_new_window();
      if(program_calc) app_calc();
      else if(program_info) app_info();
      else if(program_paint) app_paint();
      else if(program_notepad) app_notepad();
      else if(program_wifi) app_wifi();
      else if(program_sound) app_sound();
      else if(program_wallpaper) app_wallpaper();
    }
    nav();
    if(debug_mode) {
      fill(255,255,255);
      textFont(os_font);
      text ("DEBUG MODE", width-200, 40);
      text ("Mouse: " + mouseX + ", " + mouseY, width-200, 60);
      text ("Key: " + key + ", " + keyCode, width-200, 80);
    }
  }
  public void app_wallpaper() {
    fill(200,200,200);  
    if(mouseX >= 20 && mouseY >= 120 && mouseX <= 376 && mouseY <= 320) {
      rect(10,110,376,220);
      if(mousePressed) prowadzacy_desktop_wallpaper=1;
    }
    else if(mouseX >= 366 && mouseY >= 120 && mouseX <= 742 && mouseY <= 320) {
      rect(376,110,376,220);
      if(mousePressed) prowadzacy_desktop_wallpaper=2;
    }
    else if(mouseX >= 752 && mouseY >= 120 && mouseX <= 1118 && mouseY <= 320) {
      rect(742,110,376, 220);
      if(mousePressed) prowadzacy_desktop_wallpaper=3;
    }
    else if(mouseX >= 20 && mouseY >= 230 && mouseX <= 376 && mouseY <= 530) {
      rect(10,320,376,220);
      if(mousePressed) prowadzacy_desktop_wallpaper=4;
    }
    image(desktop_mwallpaper_1, 20,120);
    image(desktop_mwallpaper_2, 386,120);
    image(desktop_mwallpaper_3, 752,120);
    image(desktop_mwallpaper_4, 20,330);

  }
  public void app_wifi() {
    text("Wifi zostało wyłączone przez administratora systemu.",20,120);
  }
  public void app_sound() {
    text("Wystąpił problem ze sterownikiem dźwięku. Skontaktuj się z administratorem systemu.",20,120);
  }
  
  String app_notepad_input="";
  public void app_notepad() {
    text(app_notepad_input+"|",20,120);
  }
  public void app_paint() {
    text("Program Paint uległ awarii.",20,120);
  }
  public void app_info() {
    fill(0,0,0);
    textFont(bios_logo_font);
    text ("VIRTUAL DESKTOP", 20, 170);
    textFont(os_font);
    text ("Projekt wykonany przez Mateusza Tobor.", 20, 210);
    textFont(os_font_title2);
    text ("Źródła wykorzystanych materiałów:", 20, 250);
    textFont(os_font);
    text ("https://www.1001fonts.com/vt323-font.html", 20, 270);
    text ("https://icon-icons.com/download/45849/PNG/32/", 20, 290);
    text ("https://www.pngegg.com/en/png-zkxjq", 20, 310);
    text ("https://www.iconfinder.com/icons/285631/notepad_icon", 20, 330);
    text ("https://pngimg.com/image/33824", 20, 350);
    text ("https://pl.pngtree.com/free-png-vectors/profesor", 20, 370);
    text ("https://pl.pinterest.com/pin/666532813593604948/", 20, 390);
    text ("https://www.fontspace.com/men-in-blue-font-f2258", 20, 410);
    text ("https://512pixels.net/projects/default-mac-wallpapers-in-5k/", 20, 430);
    text ("https://www.soundjay.com/beep-sounds-1.html", 20, 450);
    text ("https://www.flaticon.com/free-icon/shut-down-icon_63769", 20, 470);
    text ("https://wallpaperaccess.com/old-mac", 20, 490);
    text ("https://szl.m.wikipedia.org/wiki/Plik:Information_icon.svg", 20, 510);
    text ("https://winaero.com/more-colorful-windows-10-icons-this-time-it-is-calculator/", 20, 530);
    text ("http://cursor.in", 20, 550);
    text ("https://commons.wikimedia.org/wiki/File:OOjs_UI_icon_logOut-ltr.svg", 20, 570);
    text ("https://www.flaticon.com/free-icon/no-wifi_2313867", 20, 590);
    text ("https://www.subpng.com/png-wdplhz/", 20, 610);
    text ("https://www.amazon.com/QConnect-Slide-Show-Maker-Pro/dp/B00I9Q3XJW", 20, 630);
    image(us_logo, width-500, 60);
  }
  
  String app_calc_a="",app_calc_b="",app_calc_c="",app_calc_result="";
  boolean app_calc_a_s=false,app_calc_b_s=false,app_calc_dot=false,app_calc_r=false;
  public void app_calc() {
    textFont(os_font_title);
    fill(0,0,0);
    text(app_calc_a + app_calc_b + app_calc_c + app_calc_result,20,150);
    //+
    if(mouseX >= 525 && mouseY >=210 && mouseX <= 625 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(525,210, 100, 100);
    fill(255,255,255);
    text("+",565,270);
    
    //1
    if(mouseX >= 630 && mouseY >=210 && mouseX <= 730 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(630,210, 100, 100);
    fill(255,255,255);
    text("1",670,270);
    
    //2
    if(mouseX >= 735 && mouseY >=210 && mouseX <= 835 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(735,210, 100, 100);
    fill(255,255,255);
    text("2",775,270);
    
    //3
    if(mouseX >= 840 && mouseY >=210 && mouseX <= 940 && mouseY <= 310) fill(0,0,0);
    else fill(80,80,80);
    rect(840, 210, 100, 100);
    fill(255,255,255);
    text("3",880,270);
    
    //---------------------
    
    //-
    if(mouseX >= 525 && mouseY >=315 && mouseX <= 625 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(525,315, 100, 100);
    fill(255,255,255);
    text("-",570,375);
    
    
    //4
    if(mouseX >= 630 && mouseY >=315 && mouseX <= 730 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(630,315, 100, 100);
    fill(255,255,255);
    text("4",670,375); 
    
    //5
    if(mouseX >= 735 && mouseY >=315 && mouseX <= 835 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(735,315, 100, 100);
    fill(255,255,255);
    text("5",775,375);
    
    //6
    if(mouseX >= 840 && mouseY >=315 && mouseX <= 940 && mouseY <= 415) fill(0,0,0);
    else fill(80,80,80);
    rect(840, 315, 100, 100);
    fill(255,255,255);
    text("6",880,375);
    
    //-----------------------------------------------
    
    //*
    if(mouseX >= 525 && mouseY >=420 && mouseX <= 625 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(525,420, 100, 100);
    fill(255,255,255);
    text("*",570,490);
    
    //7
    if(mouseX >= 630 && mouseY >=420 && mouseX <= 730 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(630,420, 100, 100);
    fill(255,255,255);
    text("7",670,480);
    
    //8
    if(mouseX >= 735 && mouseY >=420 && mouseX <= 835 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(735,420, 100, 100);
    fill(255,255,255);
    text("8",775,480);
    
    //9
    if(mouseX >= 840 && mouseY >=420 && mouseX <= 940 && mouseY <= 520) fill(0,0,0);
    else fill(80,80,80);
    rect(840,420, 100, 100);
    fill(255,255,255);
    text("9",880,480);
    
    //---------------------------------------------------------
    // C
    if(mouseX >= 420 && mouseY >=525 && mouseX <= 520 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(420,525, 100, 100);
    fill(255,255,255);
    text("C",460,585);
    
    
    // /
    if(mouseX >= 525 && mouseY >=525 && mouseX <= 625 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(525,525, 100, 100);
    fill(255,255,255);
    text("/",570,585);
    
    
    // .
    if(mouseX >= 630 && mouseY >=525 && mouseX <= 730 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(630,525, 100, 100);
    fill(255,255,255);
    text(".",675,585);
    
    // 0
    if(mouseX >= 735 && mouseY >=525 && mouseX <= 835 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(735,525, 100, 100);
    fill(255,255,255);
    text("0",775,585);
    
    // =
    if(mouseX >= 840 && mouseY >=525 && mouseX <= 940 && mouseY <= 625) fill(0,0,0);
    else fill(80,80,80);
    rect(840, 525, 100, 100);
    fill(255,255,255);
    text("=",880,585);
  }

  public void mousePressed() {
    if(mouseX >= 44 && mouseY >= 4 && mouseX <= 72 && mouseY <= 32) {
      delay(5000);
      surface.setVisible(false);
      login = new login_screen();
    }
    else if(mouseX >= 6 && mouseY >= 4 && mouseX <= 34 && mouseY <= 32) {
      surface.setVisible(false);
      shutdown = new shutdown_screen();
    }
    else if(mouseX >= 1100 && mouseY >= 4 && mouseX <= 1128 && mouseY <= 32) {
      close_program();
      program=true;
      program_title="Ustawienia WIFI";
      program_wifi=true;
      
    }
    else if(mouseX >= 1060 && mouseY >= 4 && mouseX <= 1088 && mouseY <= 32) {
      close_program();
      program=true;
      program_title="Ustawienia dźwięku";
      program_sound=true;
    }
    if(program) {
      if(mouseButton == LEFT) {
        if(mouseX >= 1210 && mouseY >= 68 && mouseX <= 1265 && mouseY <= 100) close_program();
        if(program_calc) {
          if(!app_calc_r) {
            if(mouseX >= 525 && mouseY >=210 && mouseX <= 625 && mouseY <= 310) {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="+";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 1
            else if(mouseX >= 630 && mouseY >=210 && mouseX <= 730 && mouseY <= 310) {
               if(!app_calc_b_s) {
                 app_calc_a+="1";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="1";
                 app_calc_result="";
               }
            }
            //obsluga 2
            else if(mouseX >= 735 && mouseY >=210 && mouseX <= 835 && mouseY <= 310) {
               if(!app_calc_b_s) {
                 app_calc_a+="2";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="2";
                 app_calc_result="";
               }
            }
            //obsluga 3
            else if(mouseX >= 840 && mouseY >=210 && mouseX <= 940 && mouseY <= 310) {
               if(!app_calc_b_s) {
                 app_calc_a+="3";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="3";
                 app_calc_result="";
               }
            }
            //obsluga -
            else if(mouseX >= 525 && mouseY >=315 && mouseX <= 625 && mouseY <= 415) {
              if(app_calc_a_s && app_calc_b_s &&  app_calc_c.equals("") && !app_calc_c.equals("-")) {
                app_calc_c+="-";
              }
              else if(app_calc_a_s) {
                   if(app_calc_b.equals("")) app_calc_dot=false;
                   app_calc_b="-";
                   app_calc_b_s=true;
                   app_calc_result="";
               } else if(app_calc_a.equals("") && !app_calc_a.equals("-")){
                 app_calc_a+="-";
               }
            }
            //obsluga 4
            else if(mouseX >= 630 && mouseY >=315 && mouseX <= 730 && mouseY <= 415) {
               if(!app_calc_b_s) {
                 app_calc_a+="4";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="4";
                 app_calc_result="";
               }
            }
            //obsluga 5
            else if(mouseX >= 735 && mouseY >=315 && mouseX <= 835 && mouseY <= 415) {
               if(!app_calc_b_s) {
                 app_calc_a+="5";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="5";
                 app_calc_result="";
               }
            }
            //obsluga 6
            else if(mouseX >= 840 && mouseY >=315 && mouseX <= 940 && mouseY <= 415) {
               if(!app_calc_b_s) {
                 app_calc_a+="6";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="6";
                 app_calc_result="";
               }
            }
            //obsluga *
            else if(mouseX >= 525 && mouseY >=420 && mouseX <= 625 && mouseY <= 520) {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="*";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 7
            else if(mouseX >= 630 && mouseY >=420 && mouseX <= 730 && mouseY <= 520) {
               if(!app_calc_b_s) {
                 app_calc_a+="7";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="7";
                 app_calc_result="";
               }
            }
            //obsluga 8
            else if(mouseX >= 735 && mouseY >=420 && mouseX <= 835 && mouseY <= 520) {
               if(!app_calc_b_s) {
                 app_calc_a+="8";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="8";
                 app_calc_result="";
               }
            }
            //obsluga 9
            else if(mouseX >= 840 && mouseY >=420 && mouseX <= 940 && mouseY <= 520) {
               if(!app_calc_b_s) {
                 app_calc_a+="9";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="9";
                 app_calc_result="";
               }
            }
            //obsluga /
            else if(mouseX >= 525 && mouseY >=525 && mouseX <= 625 && mouseY <= 625) {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="/";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 0
            else if(mouseX >= 735 && mouseY >=525 && mouseX <= 835 && mouseY <= 625) {
               if(!app_calc_b_s) {
                 app_calc_a+="0";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="0";
                 app_calc_result="";
               }
            }
            //obsluga .
            else if(mouseX >= 630 && mouseY >=525 && mouseX <= 730 && mouseY <= 625) {
               if(!app_calc_dot) {
                 if(!app_calc_b_s) {
                   app_calc_a+=".";
                   app_calc_a_s=true;
                   app_calc_result="";
                 } else {
                   app_calc_c+=".";
                   app_calc_result="";
                 }
                 app_calc_dot=true;
               }
            }
            
            //obsluga =
            else if(mouseX >= 840 && mouseY >=525 && mouseX <= 940 && mouseY <= 625) {
               if(!app_calc_a.equals("")) {
                 if(app_calc_c.equals("")) {
                   app_calc_result = "=" + app_calc_a + "";
                 } else {
                   //app_calc_result = new String ( (int)app_calc_a + (int)app_calc_c);
                   float a=0;
                   
                   if(app_calc_b.equals("+")) a = Float.valueOf(app_calc_a) + Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("-")) a = Float.valueOf(app_calc_a) - Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("/")) {
                     if(Float.valueOf(app_calc_c) != 0)
                     a = Float.valueOf(app_calc_a) / Float.valueOf(app_calc_c);
                     else a=0;
                   }
                   else if(app_calc_b.equals("*")) a = Float.valueOf(app_calc_a) * Float.valueOf(app_calc_c);
                   app_calc_result = "=" + (float)a + "";
                   app_calc_r=true;
                 }
               }
            }
          }
          
          //obsluga C
          if(mouseX >= 420 && mouseY >=525 && mouseX <= 520 && mouseY <= 625) {
             if(app_calc_a_s) {
               app_calc_a="";
               app_calc_b="";
               app_calc_c="";
               app_calc_a_s=false;
               app_calc_b_s=false;
               app_calc_dot=false;
               app_calc_r=false;
               app_calc_result="";
             }
          }
        }
      }
    }
  }
  
  public void keyPressed() {
    if(program) {
      if(program_notepad) {
        if(key == 'q' || key == 'w' || key == 'e' || key == 'r' || key == 't' || key == 'y' || key == 'u' || key == 'i' || key == 'o' || key == 'p' || key == '[' ||  key == ']' || 
        key == 'a' || key == 's' || key == 'd' || key == 'f' || key == 'g' || key == 'h' || key == 'j' || key == 'k' || key == 'l' || key == ';' || 
        key == 'z' || key == 'x' || key == 'c' || key == 'v' || key == 'b' || key == 'n' || key == 'm' || key == ',' || key == '.' ||
        key == 'ż' || key == 'ą' || key == 'ę' || key == 'ć' || key == 'ź' || key == 'ł' || key == 'ó' || key == '?' || key == '!' ||  
        key == 'Q' || key == 'W' || key == 'E' || key == 'R' || key == 'T' || key == 'Y' || key == 'U' || key == 'I' || key == 'O' || key == 'P' ||
        key == 'A' || key == 'S' || key == 'D' || key == 'F' || key == 'G' || key == 'H' || key == 'J' || key == 'K' || key == 'L' ||
        key == 'Z' || key == 'X' || key == 'C' || key == 'V' || key == 'B' || key == 'N' || key == 'M' ||
        key == 'Ż' || key == 'Ą' || key == 'Ę' || key == 'Ć' || key == 'Ź' || key == 'Ł' || key == 'Ó' ||
        key == '1' || key == '2' || key == '3' || key == '4' || key == '5' || key == '6' || key == '7' || key == '8' || key == '9' || key == '0' || keyCode == 10  || keyCode == 32 ||
        key == '@' || key == '#' || key == '$' || key == '%' || key == '^' || key == '&' || key == '*' || key == '(' || key == ')' || keyCode == 222 || key == '<' || key == '>' ||
        key == '"' || key == '|'  || keyCode == 92 || key == '{' || key == '}' || key == '_'  || key == '+' || key == ':'
        )
        app_notepad_input+=key;
        if(keyCode == 8) {
          if(app_notepad_input.length()>0) app_notepad_input=app_notepad_input.substring(0,app_notepad_input.length()-1);
        }
      }
      if(program_calc) {
        if(!app_calc_r) {
           if(key=='+') {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="+";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 1
            else if(key=='1') {
               if(!app_calc_b_s) {
                 app_calc_a+="1";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="1";
                 app_calc_result="";
               }
            }
            //obsluga 2
            else if(key=='2') {
               if(!app_calc_b_s) {
                 app_calc_a+="2";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="2";
                 app_calc_result="";
               }
            }
            //obsluga 3
            else if(key=='3') {
               if(!app_calc_b_s) {
                 app_calc_a+="3";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="3";
                 app_calc_result="";
               }
            }
            //obsluga -
            else if(key=='-') {
              if(app_calc_a_s && app_calc_b_s &&  app_calc_c.equals("")) {
                app_calc_c+="-";
              }
              else {
                if(app_calc_a_s) {
                   if(app_calc_b.equals("")) app_calc_dot=false;
                   app_calc_b="-";
                   app_calc_b_s=true;
                   app_calc_result="";
                 } else {
                   app_calc_a+="-";
                 }
              }
            }
            //obsluga 4
            else if(key=='4') {
               if(!app_calc_b_s) {
                 app_calc_a+="4";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="4";
                 app_calc_result="";
               }
            }
            //obsluga 5
            else if(key=='5') {
               if(!app_calc_b_s) {
                 app_calc_a+="5";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="5";
                 app_calc_result="";
               }
            }
            //obsluga 6
            else if(key=='6') {
               if(!app_calc_b_s) {
                 app_calc_a+="6";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="6";
                 app_calc_result="";
               }
            }
            //obsluga *
            else if(key=='*') {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="*";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 7
            else if(key=='7') {
               if(!app_calc_b_s) {
                 app_calc_a+="7";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="7";
                 app_calc_result="";
               }
            }
            //obsluga 8
            else if(key=='8') {
               if(!app_calc_b_s) {
                 app_calc_a+="8";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="8";
                 app_calc_result="";
               }
            }
            //obsluga 9
            else if(key=='9') {
               if(!app_calc_b_s) {
                 app_calc_a+="9";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="9";
                 app_calc_result="";
               }
            }
            //obsluga /
            else if(key=='/') {
               if(app_calc_a_s) {
                 if(app_calc_b.equals("")) app_calc_dot=false;
                 app_calc_b="/";
                 app_calc_b_s=true;
                 app_calc_result="";
               }
            }
            //obsluga 0
            else if(key=='0') {
               if(!app_calc_b_s) {
                 app_calc_a+="0";
                 app_calc_a_s=true;
                 app_calc_result="";
               } else {
                 app_calc_c+="0";
                 app_calc_result="";
               }
            }
            //obsluga .
            else if(key=='.') {
               if(!app_calc_dot) {
                 if(!app_calc_b_s) {
                   app_calc_a+=".";
                   app_calc_a_s=true;
                   app_calc_result="";
                 } else {
                   app_calc_c+=".";
                   app_calc_result="";
                 }
                 app_calc_dot=true;
               }
            }
            
            //obsluga =
            else if(key=='=' || keyCode==10) {
               if(!app_calc_a.equals("")) {
                 if(app_calc_c.equals("")) {
                   app_calc_result = "=" + app_calc_a + "";
                 } else {
                   //app_calc_result = new String ( (int)app_calc_a + (int)app_calc_c);
                   float a=0;
                   
                   if(app_calc_b.equals("+")) a = Float.valueOf(app_calc_a) + Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("-")) a = Float.valueOf(app_calc_a) - Float.valueOf(app_calc_c);
                   else if(app_calc_b.equals("/")) {
                     if(Float.valueOf(app_calc_c) != 0)
                     a = Float.valueOf(app_calc_a) / Float.valueOf(app_calc_c);
                     else a=0;
                   }
                   else if(app_calc_b.equals("*")) a = Float.valueOf(app_calc_a) * Float.valueOf(app_calc_c);
                   app_calc_result = "=" + (float)a + "";
                   app_calc_r=true;
                 }
               }
            }
        }
        //obsluga C
        else if(key=='c' || key=='C') {
           if(app_calc_a_s) {
             app_calc_a="";
             app_calc_b="";
             app_calc_c="";
             app_calc_a_s=false;
             app_calc_b_s=false;
             app_calc_dot=false;
             app_calc_r=false;
             app_calc_result="";
           }
        }
      }
    }
  }
  
  public void new_icon(int x, int y, int p, PImage icon, String title, int app_id) {
    --x;--y;
    x*=110;y*=110;
    if(!program) {
      if(mouseX >= x+10 && mouseY >= y+60 && mouseX <= x+110 && mouseY <= y+160) {
        fill(255,255,255,100);
        if(mousePressed && mouseButton == LEFT) {
          program=true;
          program_title=title;
          program_run(app_id);
        }
      }
      else fill(255,255,255,30);
    } else fill(255,255,255,30);
    noStroke();
    rect(x+10,y+60,100,100,10);
    image(icon, PApplet.parseFloat(x+27),PApplet.parseFloat(y+70));
    fill(255,255,255);
    textFont(os_font);
    text(title, PApplet.parseFloat(x+15+p), PApplet.parseFloat(y+155));
  }
  
  public void nav() {
    fill(0,0,0);
    rect(0,0,width,40,0, 0, 10, 10);
    textFont(os_font);
    fill(255,255,255);
    String hour,minute,day,month;
    if(hour()<10) hour = "0" + hour();
    else hour = "" + hour();
    if(minute()<10) minute = "0" + minute();
    else minute = "" + minute();
    if(bios_date_day < 10) day="0"+bios_date_day;
    else day="" + bios_date_day;
    if(bios_date_month < 10) month="0"+bios_date_month;
    else month="" + bios_date_month;
    text(day + "." + month + "." + bios_date_year, 1145, 25);
    text(hour + ":" + minute , 1230, 25);
    text("Zalogowany jako Prowadzący", 550, 25);
    text("PL", 1030, 25);
    
    if(mouseX >= 6 && mouseY >= 4 && mouseX <= 34 && mouseY <= 32) cursor(os_cursor_pointer);
    else if(mouseX >= 44 && mouseY >= 4 && mouseX <= 72 && mouseY <= 32) cursor(os_cursor_pointer);
    else if(mouseX >= 1100 && mouseY >= 4 && mouseX <= 1128 && mouseY <= 32) cursor(os_cursor_pointer);
    else if(mouseX >= 1060 && mouseY >= 4 && mouseX <= 1088 && mouseY <= 32) cursor(os_cursor_pointer);
    else cursor(os_cursor);
    image(os_shutdown, 6, 4);
    image(os_logout, 44, 4);
    image(os_wifi, 1100, 4);
    image(os_sound, 1060, 4);
  }
  
  public void close_program() {
    program=false;
    //dalsze opcje wyłączenia...
    if(program_calc) {
       app_calc_a="";
       app_calc_b="";
       app_calc_c="";
       app_calc_a_s=false;
       app_calc_b_s=false;
       app_calc_dot=false;
       app_calc_r=false;
       app_calc_result="";
       program_calc=false;
    }
    program_info=false;
    program_paint=false;
    program_notepad=false;
    program_wifi=false;
    program_sound=false;
    program_wallpaper=false;
  }
  
  public void program_new_window() {
    program=true;
    fill(255,255,255,200);
    rect(10,60, 1260, 40);
    fill(255,255,255);
    rect(10,100, width-20, height-120);
    int program_close_light;
    if(mouseX >= 1210 && mouseY >= 68 && mouseX <= 1265 && mouseY <= 100) program_close_light=255;
    else program_close_light=128;
    fill(program_close_light,0,0);
    rect(width-70,63, 57, 34);
    fill(255,255,255);
    textFont(os_font_title2);
    text("X", 1231, 90);
    textFont(os_font);
    fill(0,0,0);
    text(program_title, 20,85);
  }
  
  public void program_run(int app) {
    if(app == 1) program_info = true;
    else if(app == 2) program_calc = true;
    else if(app == 3) program_paint = true;
    else if(app == 4) program_notepad = true;
    else if(app == 5) program_wallpaper= true;
    
  }

  public void setWallpaper(int wallpaper) {
    if(wallpaper==1)
      background(desktop_wallpaper_1);
    else if(wallpaper==2)
      background(desktop_wallpaper_2);
    else if(wallpaper==3)
      background(desktop_wallpaper_3);
    else if(wallpaper==4)
      background(desktop_wallpaper_4);
    else background(105,104,182);
  }
}
class login_screen extends PApplet {
  login_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  public void settings() {
    size(1280, 720);
  }
  public void setup() {
    frameRate(30);
    surface.setTitle("Virtual Desktop - Login");
  }
  int logging_profile=0;
  int mess_unactive_profile = -500;//505
  int mess_logging = -500;//575
  int[] logging_student = {255,255,205};
  int[] logging_prowadzacy = {255,255,205};
  int[] logging_box_student = {55,55,88};
  int[] logging_box_prowadzacy = {55,55,88};
  public void draw() {
    background(105,104,182);
    int timer_start = 0, timer_end = 4000;
    if (millis() - timer_start > timer_end) {
      background(login_bg);
      fill(255,255,205);
      textFont(bios_logo_font);
      text("VIRTUAL DESKTOP OS", 288, 150);
      textFont(os_font_title2);
      text("Kliknij, aby zalogować",mess_logging,520);
      text("Ten profil jest nieaktywny",mess_unactive_profile,520);
      textFont(os_font);
      fill(logging_student[0],logging_student[1],logging_student[2]);
      text("Student",483,670);
      fill(logging_prowadzacy[0],logging_prowadzacy[1],logging_prowadzacy[2]);
      text("Prowadzący",598,670);
      fill(180,180,180);
      text("Gość",750,670);
      fill(255,255,255);
      fill(logging_box_student[0],logging_box_student[1],logging_box_student[2]);
      rect(460,550,100,100,10);
      fill(logging_box_prowadzacy[0],logging_box_prowadzacy[1],logging_box_prowadzacy[2]);
      rect(590,550,100,100,10);
      fill(55,55,88);
      rect(720,550,100,100,10);
      image(login_user_student, 465,555);
      image(login_user_prowadzacy, 595,555);
      image(login_user_gosc, 725,555);
      image(login_shutdown, 1200,640);
      if(mess_logging == -500 && mess_logging == -500 && mouseX >= 720 && mouseY >= 550 && mouseX <= 820 && mouseY <= 675) {
           mess_unactive_profile=505;
        } else {
           mess_unactive_profile=-500;
        }
        if(mouseX >= 720 && mouseY >= 550 && mouseX <= 820 && mouseY <= 675) cursor(os_cursor_notallowed);
        else if(mouseX >= 460 && mouseY >= 550 && mouseX <= 560 && mouseY <= 675) cursor(os_cursor_pointer);
        else if(mouseX >= 590 && mouseY >= 550 && mouseX <= 690 && mouseY <= 675) cursor(os_cursor_pointer);
        else if(mouseX >= 1200 && mouseY >= 640 && mouseX <= 1264 && mouseY <= 704) cursor(os_cursor_pointer);
        else cursor(os_cursor);
        if(mouseX >= 460 && mouseY >= 550 && mouseX <= 560 && mouseY <= 675) {
          logging_box_student[0]=0;
          logging_box_student[1]=191;
          logging_box_student[2]=255;
          logging_student[0]=0;
          logging_student[1]=191;
          logging_student[2]=255;
          
        } else {
          logging_box_student[0]=55;
          logging_box_student[1]=55;
          logging_box_student[2]=88;
          logging_student[0]=255;
          logging_student[1]=255;
          logging_student[2]=255;
        }
        if(mouseX >= 590 && mouseY >= 550 && mouseX <= 690 && mouseY <= 675) {
          logging_box_prowadzacy[0]=0;
          logging_box_prowadzacy[1]=191;
          logging_box_prowadzacy[2]=255;
          logging_prowadzacy[0]=0;
          logging_prowadzacy[1]=191;
          logging_prowadzacy[2]=255;
        } else {
          logging_box_prowadzacy[0]=55;
          logging_box_prowadzacy[1]=55;
          logging_box_prowadzacy[2]=88;
          logging_prowadzacy[0]=255;
          logging_prowadzacy[1]=255;
          logging_prowadzacy[2]=255;
        }
        if(mouseX >= 460 && mouseY >= 550 && mouseX <= 560 && mouseY <= 675 || mouseX >= 590 && mouseY >= 550 && mouseX <= 690 && mouseY <= 675)
        mess_logging = 520;
        else mess_logging = -500;
    }
    if(debug_mode) {
      fill(255,255,255);
      textFont(os_font);
      text ("DEBUG MODE", width-200, 40);
      text ("Mouse: " + mouseX + ", " + mouseY, width-200, 60);
      text ("Key: " + key + ", " + keyCode, width-200, 80);
    }
  }

  public void mousePressed() {
    if(mouseX >= 460 && mouseY >= 550 && mouseX <= 560 && mouseY <= 675) {
      delay(5000);
      surface.setVisible(false);
      desktop_student = new desktop_student_screen();
    }
    else if(mouseX >= 590 && mouseY >= 550 && mouseX <= 690 && mouseY <= 675) {
      delay(5000);
      surface.setVisible(false);
      desktop_prowadzacy = new desktop_prowadzacy_screen();
    }
    else if(mouseX >= 1200 && mouseY >= 640 && mouseX <= 1264 && mouseY <= 704) {
      surface.setVisible(false);
      shutdown = new shutdown_screen();
    }
  }
}
class shutdown_screen extends PApplet {
  shutdown_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  public void settings() {
    size(1280, 720);
  }
  public void setup() {
    frameRate(30);
    cursor(os_cursor_notallowed);
    surface.setTitle("Virtual Desktop - SHUTTING DOWN");
  }
  public void draw() {
    background(128,128,128);
    fill(255,255,205);
    textFont(bios_logo_font);
    text("VIRTUAL DESKTOP OS", (width/2)-380, 150);
    fill(255,255,255);
    textFont(os_font_title);
    text("Trwa wyłączanie systemu. Proszę czekać.", (width/2)-310, height/2);
    int timer_start = 0, timer_end = 5000;
    if (millis() - timer_start > timer_end) {
      exit();
    }
    if(debug_mode) {
      textFont(os_font);
      text ("DEBUG MODE", width-200, 40);
      text ("Mouse: " + mouseX + ", " + mouseY, width-200, 60);
      text ("Key: " + key + ", " + keyCode, width-200, 80);
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "projekt" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
