class bootmenu_screen extends PApplet {
  bootmenu_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }

  void settings() {
    size(1280, 720);
  }

  void setup() {
    frameRate(30);
    noCursor();
    surface.setTitle("Virtual Desktop - BOOT MENU");
  }

int boot_warning=-220;

  void draw() {
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
  
  void keyPressed() {
    if(keyCode>=112 && keyCode <= 123) bios_beep.play();
    if(keyCode==113 || keyCode==114) boot_warning=220;
    else if(keyCode==112) {
      surface.setVisible(false);
      login = new login_screen();
    }
  }
}
