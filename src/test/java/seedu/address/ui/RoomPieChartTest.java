package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import seedu.address.model.booking.Booking;
import seedu.address.testutil.TypicalPersons;

public class RoomPieChartTest {

    private RoomPieChart roomPieChart;
    private StackPane testPieChartPane;

    @Test
    public void constructor_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RoomPieChart(null));
    }

    @BeforeEach
    public void setUp() {
        ObservableList<Booking> bookingList = FXCollections.observableArrayList();
        for (int i = 0; i < 100; i++) {
            bookingList.add(TypicalPersons.AMY);
        }

        testPieChartPane = new StackPane();
        roomPieChart = new RoomPieChart(bookingList, testPieChartPane);
    }

    @Test
    public void testRoomPieChartCreation_nonNullInput_success() {
        PieChart pieChart = (PieChart) testPieChartPane.getChildren().get(0);

        assertNotNull(pieChart);
        assertEquals(2, pieChart.getData().size());

        PieChart.Data occupiedData = pieChart.getData().get(0);
        PieChart.Data availableData = pieChart.getData().get(1);

        assertEquals("Occupied Rooms: 100", occupiedData.getName());
        assertEquals(100, occupiedData.getPieValue(), 0.001);

        assertEquals("Available Rooms: 400", availableData.getName());
        assertEquals(400, availableData.getPieValue(), 0.001);
    }
}
