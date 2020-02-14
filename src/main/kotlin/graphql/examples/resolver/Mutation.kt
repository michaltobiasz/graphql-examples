package graphql.examples.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.examples.pojo.Speaker
import graphql.examples.pojo.SpeakerInput
import graphql.examples.service.SpeakerService
import org.springframework.stereotype.Component

@Component
class Mutation(private val speakerService: SpeakerService) : GraphQLMutationResolver {

    fun addSpeaker(speakerInput: SpeakerInput): Speaker {
        val speaker = Speaker(name = speakerInput.name, twitter = speakerInput.twitter)
        return speakerService.save(speaker)
    }

}
