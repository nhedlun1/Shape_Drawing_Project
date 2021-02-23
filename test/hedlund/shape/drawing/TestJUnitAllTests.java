package hedlund.shape.drawing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
	{ 
		TestShapeCircle.class, 
		TestShapeRectangle.class,
		TestShapeTriangle.class,
		TestShapeLine.class,
		TestShapeDrawing.class,

	}
)
public class TestJUnitAllTests {;}