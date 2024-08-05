package be.digitcom.streams.services;

import be.digitcom.streams.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStatisticsTest {

    private Player playerPatrickUnderThirty;
    private PlayerStatistics statistics;

    @BeforeEach
    void setUp() {
        playerPatrickUnderThirty = new Player("Patrick", 27);
        statistics = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
    }

    @Test
    public void playerNameEqual() {
        Player player2 = new Player("Patrick", 25);
        assertEquals(playerPatrickUnderThirty, player2, "Players not equal with same name");
    }

    @Test
    public void playerNameNotEqual() {
        Player player2 = new Player("Kalvin", 25);
        assertNotEquals(playerPatrickUnderThirty, player2, "Players equals with same name");
    }

    @Test
    public void youngerPlayerSame() {
        Player player2 = new Player("Patrick", 25);
        assertSame(player2, PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2));
    }

    @Test
    public void underThirtyTrue() {
        assertTrue(statistics.underThirty());
    }

    @Test
    public void underThirtyFalse() {
        Player player1 = new Player("Patrick", 37);
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);
        assertFalse(statistics.underThirty());
    }

    @Test
    public void csvReportNull() {
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 0, 0);
        assertNull(statistics.createCsvRecord());
    }

    @Test
    public void csvReportNotNull() {
        assertNotNull(statistics.createCsvRecord());
    }

    @Test
    public void csvReportEmpty() {
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 4, 8);
        Double[] expectedArray = {2d, 0.5};
        assertArrayEquals(expectedArray, statistics.createCsvRecord());
    }

}