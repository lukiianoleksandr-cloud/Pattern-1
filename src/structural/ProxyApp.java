package structural;

public class ProxyApp {
    public interface ThirdPartyYouTubeLib { void renderVideoPage(String id); }

    public static class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
        public void renderVideoPage(String id) { System.out.println("Скачування відео " + id + " з інтернету..."); }
    }

    public static class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
        private ThirdPartyYouTubeLib youtubeService = new ThirdPartyYouTubeClass();
        private boolean isCached = false;

        public void renderVideoPage(String id) {
            if (!isCached) {
                System.out.print("[Proxy] Кешу не знайдено. ");
                youtubeService.renderVideoPage(id);
                isCached = true;
            } else {
                System.out.println("[Proxy] Відео " + id + " миттєво завантажено з локального КЕШУ.");
            }
        }
    }
}