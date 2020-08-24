package com.pikaqiu.notice.api;

import com.pikaqiu.notice.constants.Constants;
import com.pikaqiu.notice.dto.HttpResponse;
import com.pikaqiu.notice.service.ByteTccService;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.compensable.Compensable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Compensable(interfaceClass = ByteTccService.class,
        confirmableKey = "byteTccComfirmService",
        cancellableKey = "byteTccCancelService")
@RestController
@Slf4j
public class ByteTccController {

    @Resource(name = "byteTccService")
    private ByteTccService byteTccService;

    @Transactional
    @PostMapping(value = Constants.URL_INTERNAL_PREFIX + Constants.URL_API_PREFIX + "/notice/byteTcc")
    public HttpResponse<String> testByteTcc(@RequestParam Integer id, @RequestParam BigDecimal money) throws Exception{
        byteTccService.testByteTcc(id, money);
//        throw new RuntimeException("确认阶段异常");
        return new HttpResponse<String>().setData("ok");
    }

}
