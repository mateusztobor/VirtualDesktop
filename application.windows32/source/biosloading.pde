class biosloading_screen extends PApplet {
  boolean ok_run=false;
  biosloading_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  void settings() {
    size(1280, 720);
    
  }
  String hour,minute,day,month,sec;
  void setup() {
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
    


  void draw() {
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
  
  void keyPressed() {
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
