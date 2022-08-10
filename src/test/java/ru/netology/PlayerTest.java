package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        ru.netology.GameStore store = new ru.netology.GameStore();
        ru.netology.Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        ru.netology.Player player = new ru.netology.Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    @Test
    public void mostPlayerByGenre() {
        ru.netology.GameStore store = new ru.netology.GameStore();
        ru.netology.Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        ru.netology.Game game2 = store.publishGame("Марио", "Аркады");

        ru.netology.Player player = new ru.netology.Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 5);
        player.play(game2, 3);

        ru.netology.Game expected = game;
        ru.netology.Game actual = player.mostPlayerByGenre("Аркады");
        
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckPlayOnExceptions() {
        ru.netology.GameStore store = new ru.netology.GameStore();
        ru.netology.Game game = store.publishGame("Червячки", "Аркады");
        ru.netology.Game game2 = store.publishGame("Марио", "Аркады");

        ru.netology.Player player = new ru.netology.Player("Dima");

        player.installGame(game);
        player.play(game, 4);

        assertThrows(RuntimeException.class, () -> player.play(game2, 5));
    }

    @Test
    public void shouldCheckPlayToSumHoursSameGenreGames() {
        ru.netology.GameStore store = new ru.netology.GameStore();
        ru.netology.Game game = store.publishGame("Баттл", "Аркады");
        ru.netology.Game game2 = store.publishGame("Марио", "Аркады");

        ru.netology.Player player = new ru.netology.Player("Alex");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 1);
        player.play(game2, 3);

        int expected = 4;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfPlayTimeZero() {
        ru.netology.GameStore store = new ru.netology.GameStore();
        ru.netology.Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        ru.netology.Game game2 = store.publishGame("Марио", "Аркады");

        ru.netology.Player player = new ru.netology.Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 0);
        player.play(game2, 0);
        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
}
