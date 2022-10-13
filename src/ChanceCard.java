public class ChanceCard
{
    String name;
    int cost;
    int payout;


    public ChanceCard(String name, int cost, int payout)
    {
        this.name = name;
        this.cost = cost;
        this.payout = payout;
    }



    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }

    public int getPayout()
    {
        return payout;
    }



}
