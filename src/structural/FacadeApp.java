package structural;

public class FacadeApp {
    public static class VideoFile {
        public String name;
        public VideoFile(String name) { this.name = name; }
    }

    public static class MPEG4CompressionCodec {
        public String type = "mp4";
    }

    public static class AudioMixer {
        void fix() { System.out.println("  [Facade Subsystem] Міксуємо аудіодоріжку..."); }
    }

    public static class VideoConverter {
        public void convertVideo(String fileName) {
            System.out.println("[Facade] Починаємо складний процес конвертації для: " + fileName);
            VideoFile file = new VideoFile(fileName);
            MPEG4CompressionCodec codec = new MPEG4CompressionCodec();
            AudioMixer mixer = new AudioMixer();
            mixer.fix();
            System.out.println("[Facade] Конвертація успішно завершена у формат " + codec.type);
        }
    }
}