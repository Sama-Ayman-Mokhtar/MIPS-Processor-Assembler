package sample;
import java.util.ArrayList;
    public class Controller {
        static ArrayList<String> instruction = new ArrayList<>();
        static int counter = 1;
        static void start(){
            for (String inst: instruction) {
                counter ++;
                String[] instDivided = inst.split(" ");
                if(!(instDivided[0].compareTo("and") == 0 || instDivided[0].compareTo("or") == 0
                        || instDivided[0].compareTo("nor")== 0  || instDivided[0].compareTo("add") == 0
                        || instDivided[0].compareTo("sub") == 0 || instDivided[0].compareTo("slt") == 0
                        || instDivided[0].compareTo("sll") == 0 || instDivided[0].compareTo("srl") == 0
                        || instDivided[0].compareTo("sra")== 0 || instDivided[0].compareTo("andi") == 0
                        || instDivided[0].compareTo("ori") == 0 || instDivided[0].compareTo("addi")== 0
                        || instDivided[0].compareTo("slti") == 0 || instDivided[0].compareTo("lui") == 0
                        || instDivided[0].compareTo("lw") == 0 || instDivided[0].compareTo("sw") == 0
                        || instDivided[0].compareTo("beq") == 0 || instDivided[0].compareTo("bne") == 0
                        || instDivided[0].compareTo("j") == 0 && instDivided[1] != null)){
                    int size = instDivided.length;
                    for (int i = 0; i < size - 1 ; i++) {
                        instDivided[i] = instDivided[i+1];
                    }
                }
                if(instDivided[0].compareTo("and") == 0 || instDivided[0].compareTo("or") == 0
                        || instDivided[0].compareTo("nor")== 0  || instDivided[0].compareTo("add") == 0
                        || instDivided[0].compareTo("sub") == 0 || instDivided[0].compareTo("slt") == 0 ){
                    MachineCode.RFormat(instDivided);
                }
                else if(instDivided[0].compareTo("sll") == 0 || instDivided[0].compareTo("srl") == 0
                        || instDivided[0].compareTo("sra")== 0){
                    MachineCode.RFormatShift(instDivided);
                }
                else if(instDivided[0].compareTo("andi") == 0 || instDivided[0].compareTo("ori") == 0
                        || instDivided[0].compareTo("addi")== 0 || instDivided[0].compareTo("slti") == 0 ){
                    MachineCode.Iformat(instDivided);
                }
                else if(instDivided[0].compareTo("lui") == 0 ){
                    MachineCode.IformatLUI(instDivided);
                }
                else if(instDivided[0].compareTo("lw") == 0 || instDivided[0].compareTo("sw") == 0){
                    MachineCode.IformatLWsw(instDivided);
                }
                else if(instDivided[0].compareTo("beq") == 0 || instDivided[0].compareTo("bne") == 0){
                    MachineCode.IformatBeqBne(instDivided);
                }
                else if(instDivided[0].compareTo("j") == 0 ){
                    MachineCode.Jformat(instDivided);

                }
            }
        }
    }
