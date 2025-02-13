package com.example.springboot.example1;

import com.license4j.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LicenseComponent {

    /**
     * Gets the license key from application properties "license.key" config
     * (application.properties).
     *
     * @param key
     */
    public LicenseComponent(@Value("${license.key}") String key) {
        /**
         * Build license to use in any part of the application.
         */
        License.getInstance().getBuilder()
                /**
                 * Product hash code is displayed on the License Server products
                 * page.
                 */
                .product("product-hash-code-here")
                /**
                 * Default license file will be used, to use different location
                 * uncomment below.
                 */
                //.file(System.getProperty("user.home") + File.separator + "MyProduct" + File.separator + "license.l4j")
                /**
                 * On windows only, will be created at
                 * Computer\HKEY_CURRENT_USER\SOFTWARE\MyProduct key and license
                 * value.
                 */
                //.registry("MyProduct\\license")
                .build();

        /**
         * Validate license key.
         */
        License.getInstance().validate(key);
    }

}
