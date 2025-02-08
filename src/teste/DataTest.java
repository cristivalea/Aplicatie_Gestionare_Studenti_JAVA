package teste;

import model.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTest {
    private Data data1;
    private Data data2;

    @BeforeEach
    public void initTest(){
        try{
            data1 = new Data("21/3/2024");
            data2 = new Data("12/3/2024");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testEquals () throws Exception{
        assertEquals(false, data1.equals(data2));
    }

    @Test
    public void testDiferenta() throws Exception{
        assertEquals(10, data1.diferenta(data2));
    }
}