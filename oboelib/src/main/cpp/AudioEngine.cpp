#include "AudioEngine.h"
#include <oboe/AudioStreamBuilder.h>
#include <oboe/AudioStream.h>

using namespace oboe;

void AudioEngine::start() {
    AudioStreamBuilder builder;

    builder.setCallback(this);
    builder.setDirection(Direction::Input);
    builder.setPerformanceMode(PerformanceMode::LowLatency);

    AudioStream *stream;
    Result r = builder.openStream(&stream);
    if (r != Result::OK) {

    }

    r = stream->requestStart();
    if (r != Result::OK) {

    }
}

DataCallbackResult
AudioEngine::onAudioReady(AudioStream *audioStream, void *audioData, int32_t numFrames) {
    return DataCallbackResult::Continue;
}
