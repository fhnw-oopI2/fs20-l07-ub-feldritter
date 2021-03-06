package ch.fhnw.oop2.tasky.part5.ui.screen;

import java.util.stream.IntStream;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Diese Klasse gruppiert die Lanes auf dem Bildschirm. Sie sorgt dafür, dass die Lanes
 * resizable sind.
 *
 */
final class LaneGroup extends GridPane {
	
	private static double ONE_HUNDRED_PERCENT = 100.0;
	private static double BOTTOM_HEIGHT_PERCENT = 10.0;
	private static double LANE_HEIGHT_PERCENT = ONE_HUNDRED_PERCENT - BOTTOM_HEIGHT_PERCENT;
	
	private Button create;
	private Button refresh;
	

	/**
	 * Erzeugt eine neue LaneGroup.
	 * 
	 * @param lanes Die Lanes in der Gruppe
	 */
	LaneGroup(Lane... lanes) {
		initializeControls();
		layoutControls(lanes);
	}
	
	private void initializeControls() {
		create = new Button("New");
		refresh = new Button("Refresh");
	}
	
	private void layoutControls(Lane... lanes) {
		ConstraintHelper.setRowPercentConstraint(this, LANE_HEIGHT_PERCENT);
		
		IntStream.range(0, lanes.length)
			.forEach(index -> {				
				ConstraintHelper.setColumnPercentConstraint(this, ONE_HUNDRED_PERCENT / lanes.length);				
				add(lanes[index], index, 0);
			});
		
		ConstraintHelper.setRowPercentConstraint(this, BOTTOM_HEIGHT_PERCENT);
		
		HBox buttons = new HBox();
		buttons.setSpacing(10);
		buttons.getChildren().addAll(create, refresh);
		add(buttons, 0, 1, lanes.length, 1);
		GridPane.setMargin(buttons, new Insets(7, 0, 5, 10));
	}
}
