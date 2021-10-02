import java.util.*;

public class Encryption {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private ArrayList<Character> list = new ArrayList<>();
    private ArrayList<Character> shuffledList = new ArrayList<>();
    private char character;
    private String line;
    private char[] letters;

    Encryption(){
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> shuffledList = new ArrayList<>();
        char character = ' ';

        newKey();
        askQuestion();
    }

    private void askQuestion(){
        while(true){
            System.out.println("\nWhat do you want to do ?");
            System.out.println("N - New Key");
            System.out.println("G - Get Key");
            System.out.println("E - Encrypt");
            System.out.println("D - Decrypt");
            System.out.println("Q - Quit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch(response){
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid answer!");
                    break;
            }
        }
    }

    private void newKey(){

        character = ' ';
        list.clear();
        shuffledList.clear();

        for(int i = 32; i < 127; i++){
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("A new key has been generated.");

    }

    private void getKey(){
        System.out.println("Key : ");

        for(Character x : list){
            System.out.print(x);
        }
        System.out.println();
        for (Character x : shuffledList){
            System.out.print(x);
        }
    }

    private void encrypt(){
        System.out.println("Enter a message for encryption : ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for(int i = 0; i < letters.length; i++){
            for(int j = 0; j < list.size(); j++){
                if(letters[i] == list.get(j)){
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted message : ");
        for(char x : letters ){
            System.out.print(x);
        }
        System.out.println();
    }

    private void decrypt(){

    }

    private void quit(){

    }
}
