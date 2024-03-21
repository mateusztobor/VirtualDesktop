class bios_screen extends PApplet {
  bios_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  void settings() {
    size(1280, 720);
    
  }
  String hour,minute,day,month,sec;
  void setup() {
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
  void draw() {
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
  void keyPressed() {
    if(keyCode>=112 && keyCode <= 123) bios_beep.play();
    //obsluga przyciskow
    if(keyCode==112 || keyCode==113) {
      delay(2000);
      surface.setVisible(false);
      biosloading = new biosloading_screen();
    }
  }
}
