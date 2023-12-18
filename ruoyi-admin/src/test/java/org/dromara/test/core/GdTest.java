package org.dromara.test.core;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CoordinateUtil;
import com.dtflys.forest.config.ForestConfiguration;
import org.dromara.core.core.utils.gd.GdClient;
import org.dromara.core.core.utils.gd.GdUtil;
import org.dromara.core.core.utils.gd.vo.GeoVO;
import org.dromara.core.core.utils.gd.vo.IPVO;
import org.dromara.core.core.utils.gd.vo.RegeoVO;
import org.dromara.core.core.utils.gd.vo.Weather;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("高德接口测试")
public class GdTest {

    /**
     * 创建Forest默认配置
     */
    private static final ForestConfiguration configuration = ForestConfiguration.createConfiguration();

    /**
     * 实例化GdClient
     */
    private final GdClient gdClient = configuration.createInstance(GdClient.class);

    @DisplayName("根据ip获得粗略信息 里面含经纬度可以获取详细信息")
    @Test
    public void getLocationByIp() {
        IPVO ipvo = gdClient.getLocationByIp("113.88.65.10", "4");
        Console.log(ipvo);
    }

    @DisplayName("根据ip获取地址/使用工具类")
    @Test
    public void getLocationByIp2() {
        IPVO ipvo = GdUtil.getLocationByIp("127.0.0.1", "4");
        Console.log(ipvo);
    }

    @DisplayName("地理编码")
    @Test
    public void geo() {
        GeoVO vo = GdUtil.geo("东莞市南城天安数码城");
        Console.log(vo);
    }

    @DisplayName("位置获取经纬度")
    @Test
    public void getLocationByAddress() {
        CoordinateUtil.Coordinate coordinate = GdUtil.getLocationByAddress("东莞市南城天安数码城");
        Console.log(coordinate);
    }

    @DisplayName("地理逆编码")
    @Test
    public void regeo() {
        CoordinateUtil.Coordinate coordinate = new CoordinateUtil.Coordinate(113.705015, 22.989603);
        RegeoVO regeo = GdUtil.regeo(coordinate);
        Console.log(regeo);
    }

    @DisplayName("地理逆编码获取位置")
    @Test
    public void getAddressByCoord() {
        CoordinateUtil.Coordinate coordinate = new CoordinateUtil.Coordinate(114.21, 37.32);
        String address = GdUtil.getAddressByCoord(coordinate);
        Console.log(address);
    }

    @DisplayName("地理逆编码获取adcode")
    @Test
    public void getAdcodeByCoord() {
        CoordinateUtil.Coordinate coordinate = new CoordinateUtil.Coordinate(114.21, 37.32);
        String adcode = GdUtil.getAdcodeByCoord(coordinate);
        Console.log(adcode);
    }

    @DisplayName("根据位置获取adcode")
    @Test
    public void getAdcodeByAddress() {
        String adcode = GdUtil.getAdcodeByAddress("东莞市南城天安数码城");
        Console.log(adcode);
    }

    @DisplayName("根据位置获取adcode")
    @Test
    public void getWeatherByAddress() {
        Weather.LivesDTO livesDTO = GdUtil.getWeatherByAddress("东莞市南城天安数码城");
        Console.log(livesDTO);
    }

    @DisplayName("根据经纬度获取天气")
    @Test
    public void getWeatherByCoord() {
        CoordinateUtil.Coordinate coordinate = new CoordinateUtil.Coordinate(114.21, 37.32);
        Weather.LivesDTO livesDTO = GdUtil.getWeatherByCoord(coordinate);
        Console.log(livesDTO);
    }

    @DisplayName("获取起点终点距离")
    @Test
    public void getDistance() {
        CoordinateUtil.Coordinate coordinate = new CoordinateUtil.Coordinate(113.746262, 23.046237);
        CoordinateUtil.Coordinate coordinate2 = new CoordinateUtil.Coordinate(113.716262, 21.046237);
        Long distance = GdUtil.getDistance(coordinate, coordinate2);
        Console.log(distance);
    }

}
