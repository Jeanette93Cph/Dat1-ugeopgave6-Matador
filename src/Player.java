import java.util.ArrayList;

public class Player {
    private String name;
    private BankAccount account;
    private int startPosition = 1;
    private int currentPosition = startPosition;
/*TODO: tilføj en liste til at holde på det spilleren har købt (jvf. Task 1.c)*/
    private ArrayList<Field> deeds = new ArrayList<>();

    public Player(String name, int amount) {
        this.name = name;
        account = new BankAccount(amount);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return account.getBalance();
    }


    @Override
    public String toString() {
        return name +":"+ account;

    }
/*TODO: udvid metoden sådan at den tager en instans af type Property. Denne instans skal lægges i deeds */
    public void buy(Property p, int cost){
        //add deed to deeds
        addDeed(p);
        this.account.doTransaction(-cost);
    }

    public int updatePos(int sum){

        currentPosition = currentPosition + sum;//52
        if(currentPosition >40){

          //  Field startField = board.getField(1);
          //  this.receive(startField);

            currentPosition -= 40;//currentPosition = currentPosition -40
        }
        return currentPosition;
    }

    public int getPosition() {
        return currentPosition;
    }


    public void pay(int amount)
    {
        this.account.doTransaction(-amount);
    }

    public void pay(int amount, Player p)
    {
        this.account.doTransaction(-amount);
        p.account.doTransaction(amount);
    }
    public void receive(int amount)
    {
        this.account.doTransaction(amount);
    }


    public void addDeed(Property p)
    {
        deeds.add(p);

    }

    public ArrayList<Field>getDeeds()
    {
        return deeds;
    }

    public int getPropertyValues()
    {
        // sumAsset det fulde beløb af skøder der bliver tilføjet via nedenstående loop
        int sumAsset = 0;

        for (Field sumOfAssets : deeds)
        {
            //co = hver enkelt skøde hvad det koster
            int co = sumOfAssets.getCost();
            // her tilføjer vi hvert skøde(co) til sumAsset
            sumAsset += co;
        }
        return sumAsset;
    }


}