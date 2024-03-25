package Dictionary_app;

public class Word {

		private String content;
		private int length;
		
		public Word(String content) {
			this.content=content;
			this.length=content.length();
		}
		
		public String getContent() {
			return content;
		}
		
		public void setContent(String content) {
			this.content = content;
			this.length = content.length();
		}
		
		
		public int getLength() {
			return length;
		}
		
		@Override
	    public String toString() {
	        return content;
	    }
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if(obj == null || getClass() != obj.getClass()) {
				return false;
			}
			Word other = (Word) obj; //obj word classa dönüştür
			return content.equals(other.content);
		}
		
		
}
