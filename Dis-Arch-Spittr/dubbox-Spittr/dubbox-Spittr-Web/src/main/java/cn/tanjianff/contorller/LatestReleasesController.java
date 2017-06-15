package cn.tanjianff.contorller;

import cn.tanjianff.Spittr.album.AlbumService;
import cn.tanjianff.Spittr.album.domain.Album;
import cn.tanjianff.Spittr.singleMusic.SingleMusicService;
import cn.tanjianff.Spittr.singleMusic.domain.SingleMusic;
import cn.tanjianff.Spittr.user.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tanjian on 2017/6/15.
 * 最新发布业务控制器
 */
@Controller
@RequestMapping(value = "/LatestRelease")
public class LatestReleasesController {
    private static ClassPathXmlApplicationContext context;
    private UserService userService;
    private SingleMusicService singleMusicService;
    private AlbumService albumService;
    static {
        try {
            context = BootstrapContext.getContext();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("xml加载失败!" + e);
        }
        context.start();
    }

    public LatestReleasesController() {
        // 获取远程服务代理
        this.userService = (UserService) context.getBean("userService");
        this.singleMusicService= (SingleMusicService) context.getBean("singleMusicService");
        this.albumService= (AlbumService) context.getBean("albumService");
    }
    @RequestMapping(value = "/loadData/singleMusic")
    @ResponseBody
    public List<SingleMusic> loadData4singleMusic(){
        return singleMusicService.getByUpDate();
    }

    @RequestMapping(value = "/loadData/album")
    @ResponseBody
    public List<Album> loadData4Albums(){
        return albumService.getByUpdate();
    }
}
