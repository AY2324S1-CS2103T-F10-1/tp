package seedu.address.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.model.booking.Booking;
import seedu.address.testutil.TypicalPersons;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.Assert.assertThrows;

public class RoomPieChartTest {

    private RoomPieChart roomPieChart;

    @Test
    public void constructor_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RoomPieChart(null));
    }

    @BeforeEach
    public void setUp() {
        ObservableList<Booking> bookingList = FXCollections.observableArrayList(TypicalPersons.getTypicalPersons());
        roomPieChart = new RoomPieChart(bookingList);
    }

    @Test
    public void testRoomPieChartCreation_nonNullInput_success() {
        PieChart pieChart = (PieChart) roomPieChart.roomPieChartPane.getChildren().get(0);

        assertNotNull(pieChart);
        assertEquals(2, pieChart.getData().size());

        PieChart.Data occupiedData = pieChart.getData().get(0);
        PieChart.Data availableData = pieChart.getData().get(1);

        assertEquals("Occupied Rooms: 7", occupiedData.getName());
        assertEquals(7, occupiedData.getPieValue(), 0.001);

        assertEquals("Available Rooms: 493", availableData.getName());
        assertEquals(493, availableData.getPieValue(), 0.001);
    }
}
