class shutdown_screen extends PApplet {
  shutdown_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  void settings() {
    size(1280, 720);
  }
  void setup() {
    frameRate(30);
    cursor(os_cursor_notallowed);
    surface.setTitle("Virtual Desktop - SHUTTING DOWN");
  }
  void draw() {
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
