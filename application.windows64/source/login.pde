class login_screen extends PApplet {
  login_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  void settings() {
    size(1280, 720);
  }
  void setup() {
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
  void draw() {
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

  void mousePressed() {
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
