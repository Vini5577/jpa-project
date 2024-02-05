package test.oneToOne;

import infra.DAO;
import model.oneToOne.Client;
import model.oneToOne.Seat;

public class NewClientSeat1 {
    public static void main(String[] args) {
        Seat seat = new Seat("16A");
        Client client = new Client("Carlos", seat);

        DAO<Object> dao = new DAO<>();

        dao.openT()
                .add(seat)
                .add(client)
                .closeT()
                .close();

    }
}
