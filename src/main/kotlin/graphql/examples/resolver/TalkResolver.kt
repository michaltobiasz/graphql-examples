package graphql.examples.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import graphql.examples.pojo.Speaker
import graphql.examples.pojo.Talk
import graphql.examples.service.SpeakerService
import org.springframework.stereotype.Component

@Component
class TalkResolver(private val speakerService: SpeakerService) : GraphQLResolver<Talk> {

    fun speakers(talk: Talk): List<Speaker> {
        return speakerService.findAllSpeakersForTalk(talk)
    }
}
