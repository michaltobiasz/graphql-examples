package graphql.examples.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.examples.pojo.Attendee
import graphql.examples.pojo.Human
import graphql.examples.pojo.Speaker
import graphql.examples.pojo.Talk
import graphql.examples.service.AttendeeService
import graphql.examples.service.SpeakerService
import graphql.examples.service.TalkService
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class Query(
    private val talkService: TalkService,
    private val speakerService: SpeakerService,
    private val attendeeService: AttendeeService
) : GraphQLQueryResolver {

    fun allTalks(): List<Talk> {
        return talkService.findAll()
    }

    fun allAttendees(): List<Attendee> {
        return attendeeService.findAll()
    }

    fun allSpeakers(ctx: DataFetchingEnvironment): List<Speaker> {
       // ctx.selectionSet.fields.
        return speakerService.findAll()
    }

    fun allAll(): List<Any> {
        val list1 = talkService.findAll()
        val list2 = speakerService.findAll()

        return list1.plus(list2)
    }

    fun allHumans(): List<Human> {
        val list1 = attendeeService.findAll()
        val list2 = speakerService.findAll()

        return list1.plus(list2)
    }
}
