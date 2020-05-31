package com.yan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;

import com.yan.entity.core.CarPark;
import com.yan.entity.core.Orientation;
import com.yan.entity.core.Position;
import com.yan.exceptions.MoveOutRangeException;
import com.yan.service.DriverService;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void autoDriver() throws IOException, InterruptedException {
        DriverService service = new DriverService();
        Random r = new Random();
        int cyclic = 0;
        while (cyclic < 1000) {
            cyclic += 1;

            // 创建一个停车场
            int length = r.nextInt(20) + 1;
            int width = r.nextInt(20) + 1;
            System.out.println("car park length:" + length + ",width:" + width);
            CarPark carPark = new CarPark(length, width);

            // 设置并启动车辆
            int x = r.nextInt(length);
            int y = r.nextInt(width);
            Orientation o = Orientation.East;
            service.start(x, y, o, carPark);
            int distance = 0;

            // 随机生成十个操作,然后停止,判断操作是否被正确执行
            for (int i = 0; i < 10; i++) {
                try {
                    int c = getRandomCommand();
                    switch (c) {
                        case 0:
                            distance = getRandomDistance();
                            Position ret = service.move(distance);
                            assertMoveTrue(x, y, o, distance, ret);
                            x = ret.getPositionX();
                            y = ret.getPositionY();
                            break;
                        case 1:
                            distance = getRandomDistance();
                            o = getRandomOrientation();
                            Position ret2 = service.move(o, distance);
                            assertMoveTrue(x, y, o, distance, ret2);
                            x = ret2.getPositionX();
                            y = ret2.getPositionY();
                            break;
                        case 2:
                            o = getRandomOrientation();
                            Orientation ret3 = service.trun(o);
                            assertTrunTrue(o, ret3);
                            break;
                    }
                } catch (MoveOutRangeException e) {
                    assertOutRangeException(x, y, o, distance, length, width);
                    break;
                }
            }
        }
    }

    public int getRandomCommand() {
        Random r = new Random();
        return r.nextInt(3);
    }

    public int getRandomDistance() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    public Orientation getRandomOrientation() {
        Random r = new Random();
        int o = r.nextInt(4);
        switch (o) {
            case 0:
                return Orientation.East;
            case 1:
                return Orientation.South;
            case 2:
                return Orientation.West;
            case 3:
                return Orientation.North;
        }
        return null;
    }

    public void assertMoveTrue(int x, int y, Orientation o, int d, Position result) {
        switch (o) {
            case East:
                x += d;
                break;
            case South:
                y -= d;
                break;
            case West:
                x -= d;
                break;
            case North:
                y += d;
                break;
        }
        assertEquals(result.getPositionX(), x);
        assertEquals(result.getPositionY(), y); 
    }

    public void assertTrunTrue(Orientation o, Orientation result) {
        assertEquals(result, o);
    }

    public void assertOutRangeException(int x, int y, Orientation o, int d, int length, int width) {
        switch (o) {
            case East:
                x += d;
                break;
            case South:
                y -= d;
                break;
            case West:
                x -= d;
                break;
            case North:
                y += d;
                break;
        }
        boolean flag;
        if (x < 0 || x >= length || y < 0 || y >= width) {
            // 是超出范围了，验证通过
            flag = true;
        } else {
            flag = false;
        }
        assertTrue(flag);
    }
}
