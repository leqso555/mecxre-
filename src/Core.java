public class Core {
    private Medium medium;

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public void addAmount(String client, int amount) throws MediumException {
        var balance = getBalance(client);
        if (balance + amount < 0) {
            throw new MediumException("error");
        }
        medium.write(client, Integer.toString(balance + amount));
    }

    public void getAmount(String client, int amount) throws MediumException {
        addAmount(client, -amount);
    }

    public void transferAmount(String fromClient, String toClient, int amount) throws MediumException {
        getAmount(fromClient, amount);
        addAmount(toClient, amount);
    }

    public int getBalance(String client) throws MediumException {
        return Integer.valueOf(medium.read(client));
    }


}
