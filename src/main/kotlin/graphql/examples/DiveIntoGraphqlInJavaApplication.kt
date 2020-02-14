package graphql.examples

import com.coxautodev.graphql.tools.SchemaParser
import graphql.examples.resolver.Mutation
import graphql.examples.resolver.Query
import graphql.examples.resolver.Subscription
import graphql.examples.resolver.TalkResolver
import graphql.examples.service.AttendeeService
import graphql.examples.service.SpeakerService
import graphql.examples.service.TalkService
import graphql.schema.GraphQLSchema
import graphql.servlet.SimpleGraphQLHttpServlet
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class DiveIntoGraphqlInJavaApplication(
    private val speakerService: SpeakerService,
    private val talkService: TalkService,
    private val attendeeService: AttendeeService
) {

//    @Bean
//    open fun graphQLServlet(): ServletRegistrationBean<*> {
//        return ServletRegistrationBean(
//            SimpleGraphQLHttpServlet.newBuilder(
//                buildSchema(
//                    talkService,
//                    speakerService,
//                    attendeeService
//                )
//            ).build(), "/graphql"
//        )
//    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(DiveIntoGraphqlInJavaApplication::class.java, *args)
        }

//        private fun buildSchema(
//            talkService: TalkService,
//            speakerService: SpeakerService,
//            attendeeService: AttendeeService
//        ): GraphQLSchema {
//            return SchemaParser
//                .newParser()
//                .file("graphql/schema.graphqls")
//                //                .dictionary()
//                .resolvers(
//                    Query(talkService, speakerService, attendeeService),
//                    TalkResolver(speakerService),
//                    Mutation(speakerService),
//                    Subscription()
//                )
//                .build()
//                .makeExecutableSchema()
//        }
    }
}
