package club.javafan.blog.web.controller.admin;

import club.javafan.blog.common.result.ResponseResult;
import club.javafan.blog.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/28 21:29
 * @desc 系统设置
 */
@Controller
@RequestMapping("/admin")
public class ConfigurationController {

    @Resource
    private ConfigService configService;

    @GetMapping("/configurations")
    public ModelAndView list() throws Exception {
        ModelAndView modelAndView = new ModelAndView("admin/configuration");
        modelAndView.addObject("path", "configurations");
        modelAndView.addObject("configurations", configService.getAllConfigs());
        return modelAndView;
    }

    @PostMapping("/configurations/website")
    @ResponseBody
    public ResponseResult website(@RequestParam(value = "websiteName", required = false) String websiteName,
                                  @RequestParam(value = "websiteDescription", required = false) String websiteDescription,
                                  @RequestParam(value = "websiteLogo", required = false) String websiteLogo,
                                  @RequestParam(value = "websiteIcon", required = false) String websiteIcon) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(websiteName)) {
            updateResult += configService.updateConfig("websiteName", websiteName);
        }
        if (!StringUtils.isEmpty(websiteDescription)) {
            updateResult += configService.updateConfig("websiteDescription", websiteDescription);
        }
        if (!StringUtils.isEmpty(websiteLogo)) {
            updateResult += configService.updateConfig("websiteLogo", websiteLogo);
        }
        if (!StringUtils.isEmpty(websiteIcon)) {
            updateResult += configService.updateConfig("websiteIcon", websiteIcon);
        }
        boolean b = updateResult > 0;
        return ResponseResult.successResult().setData(b);
    }

    @PostMapping("/configurations/userInfo")
    @ResponseBody
    public ResponseResult userInfo(@RequestParam(value = "yourAvatar", required = false) String yourAvatar,
                           @RequestParam(value = "yourName", required = false) String yourName,
                           @RequestParam(value = "yourEmail", required = false) String yourEmail) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(yourAvatar)) {
            updateResult += configService.updateConfig("yourAvatar", yourAvatar);
        }
        if (!StringUtils.isEmpty(yourName)) {
            updateResult += configService.updateConfig("yourName", yourName);
        }
        if (!StringUtils.isEmpty(yourEmail)) {
            updateResult += configService.updateConfig("yourEmail", yourEmail);
        }
        boolean b = updateResult > 0;
        return ResponseResult.successResult().setData(b);
    }

    @PostMapping("/configurations/footer")
    @ResponseBody
    public ResponseResult footer(@RequestParam(value = "footerAbout", required = false) String footerAbout,
                         @RequestParam(value = "footerICP", required = false) String footerICP,
                         @RequestParam(value = "footerCopyRight", required = false) String footerCopyRight,
                         @RequestParam(value = "footerPoweredBy", required = false) String footerPoweredBy,
                         @RequestParam(value = "footerPoweredByURL", required = false) String footerPoweredByURL) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(footerAbout)) {
            updateResult += configService.updateConfig("footerAbout", footerAbout);
        }
        if (!StringUtils.isEmpty(footerICP)) {
            updateResult += configService.updateConfig("footerICP", footerICP);
        }
        if (!StringUtils.isEmpty(footerCopyRight)) {
            updateResult += configService.updateConfig("footerCopyRight", footerCopyRight);
        }
        if (!StringUtils.isEmpty(footerPoweredBy)) {
            updateResult += configService.updateConfig("footerPoweredBy", footerPoweredBy);
        }
        if (!StringUtils.isEmpty(footerPoweredByURL)) {
            updateResult += configService.updateConfig("footerPoweredByURL", footerPoweredByURL);
        }
        boolean b = updateResult > 0;
        return ResponseResult.successResult().setData(b);
    }


}
