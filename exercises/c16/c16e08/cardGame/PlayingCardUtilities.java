package cardGame;

import nhUtilities.containers.*;
import java.io.*;

public class PlayingCardUtilities {

    public static void saveCard (PlayingCard card,
        String fileName) throws IOException {
        DataOutputStream out =
            new DataOutputStream(
                new FileOutputStream(fileName,true));

        out.writeInt(card.suit());
        out.writeInt(card.rank());
    }

    public static List<PlayingCard> restoreCardList (
        String fileName) throws IOException {
        DataInputStream in =
            new DataInputStream(
                new FileInputStream(fileName));

        List<PlayingCard> list = new DefaultList<PlayingCard>();
        try {
            while (true) {
                int suit = in.readInt();
                int rank = in.readInt();
                list.add(new PlayingCard(suit,rank));
            }
        } catch (EOFException e) {
                in.close();
                return list;
        }
    }
}
