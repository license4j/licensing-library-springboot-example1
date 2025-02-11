package com.example.springboot.example1;

import com.license4j.License;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        String html = """
                      <html><body><pre style="margin:auto;padding:50px;width:fit-content;">
                      
                      License Status          : %s
                      License Status Error    : %s
                      License Status Message  : %s
                      
                      License Key             : %s
                      License Type            : %s
                      License Expiration Date : %s
                      License File Location   : %s
                      
                      Licensee Full Name      : %s
                      Licensee E-Mail         : %s
                      Licensee Company        : %s
                      
                      System User Name        : %s
                      System Host Name        : %s
                      System Domain Name      : %s
                      System OS Family        : %s
                      System Java             : %s
                      System CPU Core Count   : %s
                      
                      </pre></body></html>
                      """
                .formatted(
                        License.getInstance().getStatus().isValid(),
                        License.getInstance().getStatus().getCode(),
                        License.getInstance().getStatus().getMessage(),
                        License.getInstance().getLicenseInformation().getLicenseKey(),
                        License.getInstance().getLicenseInformation().getLicenseType(),
                        License.getInstance().getLicenseInformation().getExpirationDateTime(),
                        License.getInstance().getLicenseInformation().getLicenseDataSaveLocation(),
                        License.getInstance().getLicenseeInformation().getFullName(),
                        License.getInstance().getLicenseeInformation().getEMail(),
                        License.getInstance().getLicenseeInformation().getCompany(),
                        License.getInstance().getSystemInformation().getOSUserName(),
                        License.getInstance().getSystemInformation().getOSHostName(),
                        License.getInstance().getSystemInformation().getDomainName(),
                        License.getInstance().getSystemInformation().getOSFamily(),
                        License.getInstance().getSystemInformation().getJava(),
                        License.getInstance().getSystemInformation().getCPUCoreCount());

        return html;
    }
}
