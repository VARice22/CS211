package arm_emu;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class ARM_EMU extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("ARM EMULATOR");
        stage.setWidth(1000);
        stage.setHeight(815);

        VBox vbox = new VBox();

        int[] specs={10,16,12,4};
        
        steeldan steel=new steeldan(specs);
        String[][] input=steeldan.read();
        steel.findcomd(input);
        //steel.print(input);
        LinkedList<String> reglist=steel.getreg();
        
        LinkedList<Label> labellist= new LinkedList<Label>();
        LinkedList<Label> labellist2= new LinkedList<Label>();
        for(int i=0;i<reglist.size();i++)
        {
            Label R0 = new Label("R"+i);
            R0.setTranslateX(12);
            R0.setTranslateY(-50*i);
            R0.setStyle(
                "-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 1;" +
                "-fx-border-insets: 2;" + 
                "-fx-border-radius: 2;" + 
                "-fx-border-color: blue;" +
                "-fx-text-fill: blue;");
            /*
            Label R0 = new Label("R0");
            R0.setTranslateX(12);
            R0.setTranslateY(-0);
            R0.setStyle("-fx-padding: 10;" + 
                              "-fx-border-style: solid inside;" + 
                              "-fx-border-width: 1;" +
                              "-fx-border-insets: 2;" + 
                              "-fx-border-radius: 2;" + 
                              "-fx-border-color: blue;" +
                              "-fx-text-fill: blue;");
            
            Label R1 = new Label("R1");
            R1.setTranslateX(12);
            R1.setTranslateY(-50);
            R1.setStyle("-fx-padding: 10;" + 
                              "-fx-border-style: solid inside;" + 
                              "-fx-border-width: 1;" +
                              "-fx-border-insets: 2;" + 
                              "-fx-border-radius: 2;" + 
                              "-fx-border-color: blue;" +
                              "-fx-text-fill: blue;");
            */
            
            /*
            Label R0_2 = new Label("0x0");
            R0_2.setTranslateX(50);
            R0_2.setTranslateY(-53); 
            R0_2.setStyle("-fx-padding: 10;" + 
                          "-fx-border-style: solid inside;" + 
                          "-fx-border-width: 1;" +
                          "-fx-border-insets: 2;" + 
                          "-fx-border-radius: 2;" + 
                          "-fx-border-color: grey;");
            Label R1_2 = new Label("0x0");
            R1_2.setTranslateX(50);
            R1_2.setTranslateY(-103);
            R1_2.setStyle("-fx-padding: 10;" + 
                          "-fx-border-style: solid inside;" + 
                          "-fx-border-width: 1;" +
                          "-fx-border-insets: 2;" + 
                          "-fx-border-radius: 2;" + 
                          "-fx-border-color: grey;");
            */
            //System.out.println(reglist.get(i));
            Label R0_2 = new Label(reglist.get(i));
            R0_2.setTranslateX(50);
            R0_2.setTranslateY(-50*(i+1)); 
            R0_2.setStyle(
                "-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 1;" +
                "-fx-border-insets: 2;" + 
                "-fx-border-radius: 2;" + 
                "-fx-border-color: grey;");
            
            labellist.add(R0);
            labellist2.add(R0_2);
        }
        
        vbox.setSpacing(10);
        
        for(int i=0; i<reglist.size();i++)
        {
            vbox.getChildren().add((labellist.get(i)));
            vbox.getChildren().add((labellist2.get(i)));
        }
        
        ((Group) scene.getRoot()).getChildren().add(vbox);

        stage.setScene(scene);
        stage.show();
    }
}




//vvvvvv    *****unused, discarded, and WIP*****    vvvvvv


/*
steeldan steel=new steeldan();
String[][] input=steeldan.read();
steel.findcomd(input);
launch(args);//,steel.getreg());
steel.print(input);
}
/*{
    ARM leg= new ARM(10,16,12,4);
    int sp=0;
    leg.mov(0,3);
    sp=leg.str(0,sp,64);
    leg.mov(1,7+16);
    sp=leg.str(1,sp,0);
    sp=leg.ldr(2,sp,64);
    sp=leg.ldr(3,sp,0);
    leg.mul(4,3,2);
    leg.print();
}*/        
/*{
    ARM leg= new ARM(10,16,12,4);
    int sp=0;
    leg.mov(0,3,0);
    sp=leg.str(0,sp,64,false,false);
    leg.mov(1,7+16,0);
    sp=leg.str(1,sp,0,false,false);
    sp=leg.ldr(2,sp,64,false,false);
    sp=leg.ldr(3,sp,0,false,false);
    leg.sub(4,3,2);
    leg.print();
}*/

    /*
    Label R0 = new Label("R0");
    R0.setTranslateX(12);
    R0.setTranslateY(-0);
    R0.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" +
                      "-fx-text-fill: blue;");
    Label R1 = new Label("R1");
    R1.setTranslateX(12);
    R1.setTranslateY(-50);
    R1.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" +
                      "-fx-text-fill: blue;");
    Label R2 = new Label("R2");
    R2.setTranslateX(12);
    R2.setTranslateY(-100);
    R2.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" +
                      "-fx-text-fill: blue;");
    Label R3 = new Label("R3");
    R3.setTranslateX(12);
    R3.setTranslateY(-150);
    R3.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" +
                      "-fx-text-fill: blue;");
    Label R4 = new Label("R4");
    R4.setTranslateX(12);
    R4.setTranslateY(-200);
    R4.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R5 = new Label("R5");
    R5.setTranslateX(12);
    R5.setTranslateY(-250);
    R5.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" +
                      "-fx-text-fill: blue;");
    Label R6 = new Label("R6");
    R6.setTranslateX(12);
    R6.setTranslateY(-300);
    R6.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R7 = new Label("R7");
    R7.setTranslateX(12);
    R7.setTranslateY(-350);
    R7.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R8 = new Label("R8");
    R8.setTranslateX(12);
    R8.setTranslateY(-400);
    R8.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R9 = new Label("R9");
    R9.setTranslateX(12);
    R9.setTranslateY(-450);
    R9.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R10 = new Label("R10");
    R10.setTranslateX(5);
    R10.setTranslateY(-500);
    R10.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R11 = new Label("R11");
    R11.setTranslateX(5);
    R11.setTranslateY(-550);
    R11.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R12 = new Label("R12");
    R12.setTranslateX(5);
    R12.setTranslateY(-600);
    R12.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    Label R13 = new Label("R13");
    R13.setTranslateX(5);
    R13.setTranslateY(-650);
    R13.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 1;" +
                      "-fx-border-insets: 2;" + 
                      "-fx-border-radius: 2;" + 
                      "-fx-border-color: blue;" + 
                      "-fx-text-fill: blue;");
    /

    //text


    Label R0_2 = new Label("0x0");
    R0_2.setTranslateX(50);
    R0_2.setTranslateY(-53); 
    R0_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R1_2 = new Label("0x0");
    R1_2.setTranslateX(50);
    R1_2.setTranslateY(-103);
    R1_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R2_2 = new Label("0x0");
    R2_2.setTranslateX(50);
    R2_2.setTranslateY(-153);
    R2_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R3_2 = new Label("0x0");
    R3_2.setTranslateX(50);
    R3_2.setTranslateY(-203);
    R3_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R4_2 = new Label("0x0");
    R4_2.setTranslateX(50);
    R4_2.setTranslateY(-253);
    R4_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R5_2 = new Label("0x0");
    R5_2.setTranslateX(50);
    R5_2.setTranslateY(-303);
    R5_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R6_2 = new Label("0x0");
    R6_2.setTranslateX(50);
    R6_2.setTranslateY(-353);
    R6_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R7_2 = new Label("0x0");
    R7_2.setTranslateX(50);
    R7_2.setTranslateY(-403);
    R7_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R8_2 = new Label("0x0");
    R8_2.setTranslateX(50);
    R8_2.setTranslateY(-453);
    R8_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R9_2 = new Label("0x0");
    R9_2.setTranslateX(50);
    R9_2.setTranslateY(-503);
    R9_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R10_2 = new Label("0x0");
    R10_2.setTranslateX(50);
    R10_2.setTranslateY(-553);
    R10_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R11_2 = new Label("0x0");
    R11_2.setTranslateX(50);
    R11_2.setTranslateY(-603);
    R11_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R12_2 = new Label("0x0");
    R12_2.setTranslateX(50);
    R12_2.setTranslateY(-653);
    R12_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");
    Label R13_2 = new Label("0x00000000000");
    R13_2.setTranslateX(50);
    R13_2.setTranslateY(-703);
    R13_2.setStyle("-fx-padding: 10;" + 
                  "-fx-border-style: solid inside;" + 
                  "-fx-border-width: 1;" +
                  "-fx-border-insets: 2;" + 
                  "-fx-border-radius: 2;" + 
                  "-fx-border-color: grey;");


    vbox.setSpacing(10);

    vbox.getChildren().add((R0)); 
    vbox.getChildren().add((R0_2));
    vbox.getChildren().add((R1));
    vbox.getChildren().add((R1_2));
    vbox.getChildren().add((R2));
    vbox.getChildren().add((R2_2));
    vbox.getChildren().add((R3));
    vbox.getChildren().add((R3_2));
    vbox.getChildren().add((R4));
    vbox.getChildren().add((R4_2));
    vbox.getChildren().add((R5));
    vbox.getChildren().add((R5_2));
    vbox.getChildren().add((R6));
    vbox.getChildren().add((R6_2));
    vbox.getChildren().add((R7));
    vbox.getChildren().add((R7_2));
    vbox.getChildren().add((R8));
    vbox.getChildren().add((R8_2));
    vbox.getChildren().add((R9));
    vbox.getChildren().add((R9_2));
    vbox.getChildren().add((R10));
    vbox.getChildren().add((R10_2));
    vbox.getChildren().add((R11));
    vbox.getChildren().add((R11_2));
    vbox.getChildren().add((R12));
    vbox.getChildren().add((R12_2));
    vbox.getChildren().add((R13));
    vbox.getChildren().add((R13_2));


    ((Group) scene.getRoot()).getChildren().add(vbox);

    stage.setScene(scene);
    stage.show();
*/