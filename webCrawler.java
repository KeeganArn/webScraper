package webCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class webCrawler {
    // list of proxy addresses and ports
    private static final List<Proxy> PROXIES = Arrays.asList(
            new Proxy("35.185.196.38", 3128),
            new Proxy("115.97.103.72", 3128),
            new Proxy("185.217.136.67", 1337),
            new Proxy("47.242.47.64", 8888),
            new Proxy("47.91.109.17", 1720),
            new Proxy("157.254.53.50", 80),
            new Proxy("81.200.149.178", 80),
            new Proxy("119.9.77.49", 8080),
            new Proxy("158.255.77.169", 80),
            new Proxy("8.210.17.35", 3128),
            new Proxy("47.178.24.220", 80),
            new Proxy("8.220.204.215", 9080),
            new Proxy("143.42.66.91", 80),
            new Proxy("49.249.155.3", 80),
            new Proxy("160.86.242.23", 8080),
            new Proxy("181.41.194.186", 80),
            new Proxy("213.233.177.134", 80),
            new Proxy("43.255.113.232", 8085),
            new Proxy("192.73.244.36", 80),
            new Proxy("65.108.207.6", 80),
            new Proxy("198.49.68.80", 80),
            new Proxy("47.56.110.204", 8989),
            new Proxy("85.215.64.49", 80),
            new Proxy("87.98.148.98", 80),
            new Proxy("162.223.90.130", 80),
            new Proxy("198.44.255.3", 80),
            new Proxy("165.232.129.150", 80),
            new Proxy("23.88.51.178", 8888),
            new Proxy("51.210.54.186", 80),
            new Proxy("23.247.136.245", 80),
            new Proxy("188.75.79.14", 80),
            new Proxy("189.240.60.164", 9090),
            new Proxy("189.240.60.166", 9090),
            new Proxy("87.248.129.26", 80),
            new Proxy("65.108.9.181", 80),
            new Proxy("114.129.2.82", 8081),
            new Proxy("51.89.255.67", 80),
            new Proxy("114.156.77.107", 8080),
            new Proxy("43.134.68.153", 3128),
            new Proxy("20.111.54.16", 8123),
            new Proxy("43.153.207.93", 3128),
            new Proxy("172.232.180.108", 80),
            new Proxy("41.204.53.17", 80),
            new Proxy("23.94.136.205", 80),
            new Proxy("4.175.200.138", 8080),
            new Proxy("198.199.86.11", 8080),
            new Proxy("133.18.234.13", 80),
            new Proxy("138.68.60.8", 8080),
            new Proxy("15.235.153.57", 8089),
            new Proxy("194.182.178.90", 3128),
            new Proxy("66.29.154.103", 3128),
            new Proxy("8.219.97.248", 80),
            new Proxy("47.88.31.196", 8080),
            new Proxy("20.206.106.192", 8123),
            new Proxy("20.210.113.32", 8123),
            new Proxy("47.74.152.29", 8888),
            new Proxy("43.134.32.184", 3128),
            new Proxy("45.119.133.218", 3128),
            new Proxy("178.128.199.145", 80),
            new Proxy("82.102.10.253", 80),
            new Proxy("189.43.42.96", 80),
            new Proxy("67.43.236.18", 1853),
            new Proxy("72.10.160.93", 13931),
            new Proxy("209.97.150.167", 3128),
            new Proxy("50.217.226.41", 80),
            new Proxy("178.128.113.118", 23128),
            new Proxy("203.115.101.55", 80),
            new Proxy("139.59.1.14", 8080),
            new Proxy("50.207.199.86", 80),
            new Proxy("50.217.226.44", 80),
            new Proxy("139.162.78.109", 8080),
            new Proxy("203.115.101.61", 80),
            new Proxy("0.0.0.0", 80),
            new Proxy("50.172.75.122", 80),
            new Proxy("50.172.75.120", 80),
            new Proxy("211.128.96.206", 80),
            new Proxy("20.24.43.214", 80),
            new Proxy("68.185.57.66", 80),
            new Proxy("50.172.75.114", 80),
            new Proxy("50.231.104.58", 80),
            new Proxy("50.174.7.156", 80),
            new Proxy("50.207.199.81", 80),
            new Proxy("188.40.59.208", 3128),
            new Proxy("127.0.0.7", 80),
            new Proxy("172.191.74.198", 8080),
            new Proxy("103.115.227.198", 8071),
            new Proxy("41.33.203.234", 1975),
            new Proxy("190.107.237.16", 999),
            new Proxy("38.191.200.52", 999),
            new Proxy("178.48.68.61", 18080),
            new Proxy("58.9.2.49", 5002),
            new Proxy("46.47.197.210", 3128),
            new Proxy("138.197.148.215", 80),
            new Proxy("159.203.61.169", 3128),
            new Proxy("45.92.108.112", 80),
            new Proxy("116.102.111.238", 10001),
            new Proxy("36.92.193.189", 80),
            new Proxy("74.208.245.106", 8888),
            new Proxy("43.153.208.148", 3128),
            new Proxy("122.10.225.55", 8000),
            new Proxy("159.65.244.233", 80),
            new Proxy("41.169.69.91", 3128),
            new Proxy("47.251.43.115", 33333),
            new Proxy("31.220.43.112", 40061),
            new Proxy("185.164.73.117", 80),
            new Proxy("161.35.70.249", 8080),
            new Proxy("144.126.216.57", 80),
            new Proxy("223.135.156.183", 8080),
            new Proxy("123.30.154.171", 7777),
            new Proxy("91.92.155.207", 3128),
            new Proxy("66.29.154.105", 3128),
            new Proxy("45.189.252.233", 999),
            new Proxy("118.99.119.228", 8080),
            new Proxy("27.147.140.129", 58080),
            new Proxy("195.159.124.57", 85),
            new Proxy("103.153.62.155", 8080),
            new Proxy("68.183.189.168", 8888),
            new Proxy("196.223.129.21", 80),
            new Proxy("78.28.152.113", 80)

            // add more proxies as needed
    );

    public static void main(String[] args) throws Exception {
        String url = "https://httpbin.io/ip";
       
        // retry mechanism in case of failure
        boolean success = false;
        while (!success) {
            Proxy proxy = getRandomProxy();
            try {
                // set up the connection options with Jsoup
                Document doc = Jsoup
                        .connect(url)
                        .ignoreContentType(true)
                        .proxy(proxy.address, proxy.port)
                        .get();
               
                String htmlOutput = doc.outerHtml();
              //Get input yes or no for save html output to a txt file
                System.out.println("Would you like to save this to a txt file");
                Scanner in = new Scanner(System.in);
                String saveOrDont = in.next();
                if (saveOrDont.contains("yes")) {
                	//pull methods from htmlToTxtFile
                	htmlToTxtFile save = new htmlToTxtFile();
                	save.saveToTxt(htmlOutput);
                }

                // print the output in the console
                System.out.println(htmlOutput);
               
                success = true; // exit the loop if successful
            } catch (IOException e) {
                System.err.println("Failed with proxy " + proxy + ": " + e.getMessage());
            }
        }
    }

    // get a random proxy from the list
    private static Proxy getRandomProxy() {
        Random random = new Random();
        return PROXIES.get(random.nextInt(PROXIES.size()));
    }

    // inner class to store proxy details
    static class Proxy {
        String address;
        int port;

        Proxy(String address, int port) {
            this.address = address;
            this.port = port;
        }

        @Override
        public String toString() {
            return address + ":" + port;
        }
    }
}

