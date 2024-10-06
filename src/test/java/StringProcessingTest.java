import org.example.StringProccesing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessingTest {
//    StringProcessor processor = new StringProcessor();
    StringProccesing processor = new StringProccesing();

    @Test
    public void testIsStrongPassword() {
        assertTrue(processor.isStrongPassword("Abcdef@1")); // Valid strong password
        assertFalse(processor.isStrongPassword("abcdef"));   // No uppercase, digit or special char
        assertFalse(processor.isStrongPassword("Abcdef1"));  // No special character
        assertFalse(processor.isStrongPassword("ABCDEF@1")); // No lowercase
        assertFalse(processor.isStrongPassword("Ab1@"));     // Too short
    }

    @Test
    public void testCalculateDigits() {
        assertEquals(3, processor.calculateDigits("Hello123"));
        assertEquals(0, processor.calculateDigits("Hello World!"));
        assertEquals(5, processor.calculateDigits("98765"));
        assertEquals(0, processor.calculateDigits(""));
        assertEquals(0, processor.calculateDigits(null));
    }

    @Test
    public void testCalculateWords() {
        assertEquals(5, processor.calculateWords("This is a test sentence."));
        assertEquals(0, processor.calculateWords("   "));   // Only spaces
        assertEquals(1, processor.calculateWords("Word"));
        assertEquals(0, processor.calculateWords(""));
        assertEquals(0, processor.calculateWords(null));
    }

    @Test
    public void testEvaluateExpression() {
        assertEquals(5, processor.calculateExpression("2+3"));
        assertEquals(14, processor.calculateExpression("2+3*(4)")); // Testing parentheses
        assertEquals(3, processor.calculateExpression("(8-2)/2"));
        assertEquals(8, processor.calculateExpression("2+3*4/2"));
        assertThrows(ArithmeticException.class, () -> processor.calculateExpression("2/0")); // Division by zero
    }
}
