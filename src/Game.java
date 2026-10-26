import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private int maxPlayers;
    private List<Player> players;
    private String path = "data/test.csv";
    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();

    }

    public void startSession() {
        try {
            ArrayList<String> data = io.readData(path);
            data 

        } catch (FileNotFoundException)
    }

    public void registerPlayers(){
        //boolean
        while(this.players.size() <= this.maxPlayers) {

            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0);
        }
    }


    private void createPlayer(String name, int score){
        Player p = new Player(name, score);
        players.add(p);
    }

    public void displayPlayers(){
        for(Player p:players){
            System.out.println(p);
        }

    }

    public void endSession() {
        String header = "Name, score";
        ArrayList<String> playerData = new ArrayList<>();
        for (Player p : players) {
            playerData.add(p.toString());
        }

        io.saveGame(playerData, path, header);


    }
}