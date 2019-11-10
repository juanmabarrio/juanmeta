package es.urjccode.mastercloudapps.adcs.draughts.views;

import static junit.framework.TestCase.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateViewTest {

    @Mock
    Console console;

    @InjectMocks
    CoordinateView coordinateView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReadOriginAndTarget() {
        String message = "Mueven las negras: ";
        when(console.readString(message)).thenReturn("32.41\n");
        Coordinate[] coordinates = coordinateView.readOriginAndTarget(message);
        Coordinate[] shouldBe = {new Coordinate(2, 1), new Coordinate(3, 0)};
        assertEquals(shouldBe[0], coordinates[0]);
        assertEquals(shouldBe[1], coordinates[1]);

    }

    @Test
    public void testReadIncorrectOriginAndTarget() {
        String message = "Mueven las negras: ";
        when(console.readString(message)).thenReturn("99.99\n").thenReturn("32.41\n");
        coordinateView.readOriginAndTarget(message);
        verify(console).writeln(Error.OUT_COORDINATE.name());
    }

}

