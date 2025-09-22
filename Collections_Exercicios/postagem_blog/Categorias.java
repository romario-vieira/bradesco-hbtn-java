public enum Categorias {
    DEVOPS, DESENVOLVIMENTO, DATA_SCIENCE;

    @Override
    public String toString() {
        switch(this) {
            case DEVOPS: return "DEVOPS";
            case DESENVOLVIMENTO: return "DESENVOLVIMENTO";
            case DATA_SCIENCE: return "DATA_SCIENCE";
            default: return "";
        }
    }
}
