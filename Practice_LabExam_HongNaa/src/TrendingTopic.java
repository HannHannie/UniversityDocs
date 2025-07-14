import java.util.*;

public class TrendingTopic {
    static class Topic implements Comparable<Topic> {
        long id, newZScore, change;

        Topic(long id, long newZScore, long change) {
            this.id = id;
            this.newZScore = newZScore;
            this.change = change;
        }

        @Override
        public int compareTo(Topic other) {
            if (this.change != other.change)
                return Long.compare(other.change, this.change);
            return Long.compare(other.id, this.id);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTopics = scanner.nextInt();
        PriorityQueue<Topic> trendingTopics = new PriorityQueue<>();
        Map<Long, Long> topicToNewZScore = new HashMap<>();

        for (int i = 0; i < numberOfTopics; i++) {
            long topicId = scanner.nextLong();
            long oldZScore = scanner.nextLong();
            long postCount = scanner.nextLong();
            long likeCount = scanner.nextLong();
            long commentCount = scanner.nextLong();
            long shareCount = scanner.nextLong();

            long calculatedZScore = postCount * 50 + likeCount * 5 + commentCount * 10 + shareCount * 20;
            long zScoreDifference = Math.abs(calculatedZScore - oldZScore);
            trendingTopics.add(new Topic(topicId, calculatedZScore, zScoreDifference));
            topicToNewZScore.put(topicId, calculatedZScore);
        }

        for (int i = 0; i < 5 && !trendingTopics.isEmpty(); i++) {
            Topic topTopic = trendingTopics.poll();
            System.out.println(topTopic.id + " " + topicToNewZScore.get(topTopic.id));
        }
    }
}
