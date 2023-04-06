package com.example.blog;

import com.example.blog.entity.Post;
import com.example.blog.repository.PostRepository;
import com.example.blog.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PostService postService) {
        String content = getDummyContent();
        return args -> {
            postService.createPost(new Post("How to be Epic at Programming", "Parker Storck", content));
            postService.createPost(new Post("Building Applications with Spring Boot and Thymeleaf", "Parker Storck", content));
            postService.createPost(new Post("Score More: An Expert's Guide to Hockey", "Parker Storck", content));
        };
    }

    private String getDummyContent() {
        return "\tLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Et pharetra pharetra massa massa ultricies mi quis hendrerit dolor. Bibendum at varius vel pharetra vel turpis. Sit amet massa vitae tortor condimentum lacinia quis vel. Integer feugiat scelerisque varius morbi. Aliquet bibendum enim facilisis gravida. Lorem sed risus ultricies tristique. Bibendum est ultricies integer quis auctor. Aliquet porttitor lacus luctus accumsan tortor posuere ac ut. Id eu nisl nunc mi ipsum faucibus vitae aliquet. Nam libero justo laoreet sit amet cursus sit amet. Vulputate ut pharetra sit amet aliquam id diam. Sed egestas egestas fringilla phasellus faucibus scelerisque eleifend donec pretium. Adipiscing elit ut aliquam purus sit amet. Consequat interdum varius sit amet mattis vulputate enim. Tristique magna sit amet purus gravida quis blandit. Mattis molestie a iaculis at erat pellentesque. Facilisis sed odio morbi quis commodo odio aenean sed adipiscing.\n\n" +
                "\tTempus egestas sed sed risus pretium quam vulputate dignissim suspendisse. Sit amet nisl purus in mollis nunc sed id. Pellentesque nec nam aliquam sem et tortor consequat. Proin nibh nisl condimentum id venenatis. Suspendisse interdum consectetur libero id faucibus nisl tincidunt. At risus viverra adipiscing at in tellus integer. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Facilisis volutpat est velit egestas dui id ornare arcu. Massa eget egestas purus viverra accumsan. Tincidunt augue interdum velit euismod in pellentesque massa. Metus aliquam eleifend mi in nulla posuere sollicitudin aliquam. Vitae tortor condimentum lacinia quis vel eros. Nulla facilisi morbi tempus iaculis urna id volutpat lacus.\n\n" +
                "\tTellus mauris a diam maecenas sed. Eu feugiat pretium nibh ipsum consequat nisl. In hac habitasse platea dictumst. Orci sagittis eu volutpat odio facilisis mauris. Odio euismod lacinia at quis risus sed vulputate odio. Interdum posuere lorem ipsum dolor. Pulvinar mattis nunc sed blandit libero volutpat sed cras ornare. Nascetur ridiculus mus mauris vitae ultricies leo. Senectus et netus et malesuada fames ac turpis. Imperdiet sed euismod nisi porta lorem mollis aliquam ut.\n\n" +
                "\tNunc lobortis mattis aliquam faucibus purus in massa tempor nec. Nam libero justo laoreet sit amet cursus sit amet dictum. Fringilla est ullamcorper eget nulla facilisi etiam dignissim diam. Iaculis at erat pellentesque adipiscing commodo elit at. Ipsum nunc aliquet bibendum enim facilisis. Elementum nisi quis eleifend quam. Lectus mauris ultrices eros in cursus turpis. Vel pharetra vel turpis nunc eget. Sed faucibus turpis in eu. Dolor sed viverra ipsum nunc aliquet bibendum enim facilisis gravida. Sed libero enim sed faucibus turpis in. Cursus mattis molestie a iaculis at. Morbi tristique senectus et netus et malesuada. Vitae turpis massa sed elementum tempus egestas sed sed risus. Ut consequat semper viverra nam libero. Urna nec tincidunt praesent semper feugiat nibh sed. Non odio euismod lacinia at. Eu lobortis elementum nibh tellus molestie nunc non blandit massa. Phasellus faucibus scelerisque eleifend donec pretium vulputate sapien.\n\n" +
                "\tNibh venenatis cras sed felis eget velit. Arcu ac tortor dignissim convallis aenean et. Aenean sed adipiscing diam donec. Cursus mattis molestie a iaculis at erat. Tempor orci eu lobortis elementum. Aliquet risus feugiat in ante metus dictum at. Velit dignissim sodales ut eu sem integer. Tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce. Nulla facilisi morbi tempus iaculis urna id volutpat lacus. Tortor posuere ac ut consequat semper viverra nam libero justo. Congue quisque egestas diam in arcu cursus. Sit amet mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Cursus turpis massa tincidunt dui.";
    }
}
