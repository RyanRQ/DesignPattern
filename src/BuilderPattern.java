/**
 * 建造者模式
 */
class Computer {
    private String cpuName;
    private String memary;
    private String HDSize;

    public static class Builder {
        private Computer computer = new Computer();

        public Builder setCpu(String name) {
            computer.cpuName = name;
            return this;
        }

        public Builder setMemary(String memary) {
            computer.memary = memary;
            return this;
        }

        public Builder setHDSize(String size) {
            computer.HDSize = size;
            return this;
        }

        public Computer create() {
            return computer;
        }
    }

    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpuName='" + cpuName + '\'' +
                ", memary='" + memary + '\'' +
                ", HDSize='" + HDSize + '\'' +
                '}';
    }
}
class Builder {
    public static void main(String[] args) {
        new Computer.Builder().setCpu("I7-6700K")
                .setMemary("2GB")
                .setHDSize("1TB").create().show();
    }
}

