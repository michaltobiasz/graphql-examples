package graphql.examples.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import graphql.examples.pojo.Speaker
import graphql.examples.pojo.Talk
import graphql.examples.service.SpeakerService
import graphql.examples.service.TalkService
import org.springframework.stereotype.Component

@Component
class SpeakerResolver(private val talkService: TalkService) : GraphQLResolver<Speaker> {

    fun talks(speaker: Speaker): List<Talk> {
        return talkService.findAllTalksBySpeaker(speaker)
    }
}
