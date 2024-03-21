class desktop_student_screen extends PApplet {
  desktop_student_screen() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }
  
  void settings() {
    size(1280, 720);
  }

  void setup() {
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
            
void draw() {
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
  void app_wallpaper() {
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
  void app_wifi() {
    text("Wifi zostało wyłączone przez administratora systemu.",20,120);
  }
  void app_sound() {
    text("Wystąpił problem ze sterownikiem dźwięku. Skontaktuj się z administratorem systemu.",20,120);
  }
  
  String app_notepad_input="";
  void app_notepad() {
    text(app_notepad_input+"|",20,120);
  }
  void app_paint() {
    text("Program Paint uległ awarii.",20,120);
  }
  void app_info() {
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
  void app_calc() {
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

  void mousePressed() {
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
  
  void keyPressed() {
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
  
  void new_icon(int x, int y, int p, PImage icon, String title, int app_id) {
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
    image(icon, float(x+27),float(y+70));
    fill(255,255,255);
    textFont(os_font);
    text(title, float(x+15+p), float(y+155));
  }
  
  void nav() {
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
  
  void close_program() {
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
  
  void program_new_window() {
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
  
  void program_run(int app) {
    if(app == 1) program_info = true;
    else if(app == 2) program_calc = true;
    else if(app == 3) program_paint = true;
    else if(app == 4) program_notepad = true;
    else if(app == 5) program_wallpaper= true;
    
  }

  void setWallpaper(int wallpaper) {
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
