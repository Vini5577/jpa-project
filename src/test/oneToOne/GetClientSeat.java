package test.oneToOne;

import infra.DAO;
import model.oneToOne.Client;
import model.oneToOne.Seat;

public class GetClientSeat {

    public static void main(String[] args) {

        DAO<Client> daoClient = new DAO<>(Client.class);

        Client client = daoClient.getId(1L);
        System.out.println(client.getSeat().getName());
        System.out.println(client.getSeat().getClient().getName());
        daoClient.close();

        DAO<Seat> daoSeat = new DAO<>(Seat.class);
        Seat seat = daoSeat.getId(1L);
        System.out.println(seat.getClient().getName());

        daoSeat.close();
    }
}
